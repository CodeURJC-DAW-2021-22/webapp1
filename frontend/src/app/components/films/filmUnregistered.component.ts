import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/filmComments.model";
import { Page } from "src/app/models/rest/page.model";
import { FilmsService } from "src/app/services/film.service";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    templateUrl: './filmUnregistered.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css',
    '../../../assets/css/jquery.rateyo.component.css', '../../../assets/css/loadingButton.component.css',]
})
export class FilmUnregisteredComponent implements OnInit {
    
    filmComments!: FilmComments;
    film!: Film;
    comments!: Comment[];
    similar!: Film[];

    constructor(private router: Router, private activatedRouter: ActivatedRoute, private service: FilmsService){
        
    }

    ngOnInit(): void {
        const id = this.activatedRouter.snapshot.params['id'];
        this.service.getFilm(id).subscribe(
            //this.filmComments => this.update(this.filmComments),
            error => console.log(error)
        );
    }

    update(response:FilmComments){
        this.filmComments = response;
        this.film = this.filmComments.film;
        this.comments = this.filmComments.comments.content;
        this.similar = this.filmComments.film.similar;
    }

    /*filmImage (film: Film) {
        return this.service.downloadImage(film);
    }*/
    
}