import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Film } from "src/app/models/film.model";
import { Page } from "src/app/models/rest/page.model";
import { FilmsService } from "src/app/services/film.service";
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './searchFilms.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class SearchFilmsComponent implements OnInit {

    admin: boolean = false;
    registered: boolean = false;
    unregistered: boolean = false;

    films: Film[] =[];
    index: number = 0;
    loaderMore: boolean = false;

    fieldText: String = "";
    token: any;

    constructor(private router: Router,  private activatedRouter: ActivatedRoute, private service: FilmsService, private loginService: LoginService){ 
        if (this.loginService.isLogged()){
            if (this.loginService.isAdmin()) {
                this.admin = true;
            } else {
                this.registered = true;
            }
        } else {
            this.unregistered = true;
        }        
    }
    
    ngOnInit(): void {
        let query = this.activatedRouter.snapshot.params['query'];
        this.update(query);
    }

    update(query: String) {
        this.service.searchFilm(query, this.index).subscribe(
            response => this.films=response.content,
            error => console.log(error)
        );
    }

    filmImage (film: Film) {
        return this.service.downloadImage(film);
    }

    loadMore() {
        this.loaderMore = true;
        this.index += 1;
        let query = this.activatedRouter.snapshot.params['query'];
        this.service.searchFilm(query, this.index).subscribe(
            response => this.insertFilms(response),
            error => console.log(error)
        );
    }

    insertFilms(response: Page<Film>) {
        if (response != null) {
            response.content.forEach( (film) => {
                this.films.push(film);
            });
        }        
        this.loaderMore = false;
    }

}