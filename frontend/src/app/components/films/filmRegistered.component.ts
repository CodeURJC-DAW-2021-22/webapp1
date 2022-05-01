import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/filmComments.model";
import { User } from "src/app/models/user.model";
import { FilmsService } from "src/app/services/film.service";
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './filmRegistered.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css',
    '../../../assets/css/jquery.rateyo.component.css', '../../../assets/css/loadingButton.component.css',]
})

export class FilmRegisteredComponent implements OnInit {

    filmComments!: FilmComments;
    film!: Film;
    comments!: Comment[];
    similar!: Film[];
    visible: boolean = true;
    user: User | undefined;

    constructor(private router: Router, private activatedRouter: ActivatedRoute, private service: FilmsService, private loginService: LoginService) { }
    
    ngOnInit(): void {
        const id = this.activatedRouter.snapshot.params['id'];
        this.user = this.loginService.currentUser();
        this.update(id);
    }

    update(id: number) {
        this.service.getFilm(id).subscribe(
            response => {
                this.filmComments = response;
                this.film = this.filmComments.film;
                this.comments = this.filmComments.comments.content;
                this.similar = this.film.similar;
            },
            error => console.log(error)
        );
    }

    filmImage(film: Film) {
        return this.service.downloadImage(film);
    }

    account(){
        this.router.navigate(['/profile/', this.user?.id]);
    }

}