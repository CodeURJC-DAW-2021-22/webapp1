import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/filmComments.model";
import { FilmsService } from "src/app/services/film.service";
import { CommentService } from "src/app/services/comment.service";
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './film.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css',
        '../../../assets/css/jquery.rateyo.component.css', '../../../assets/css/loadingButton.component.css',]
})

export class FilmComponent implements OnInit {

    filmComments!: FilmComments;
    film!: Film;
    comments: Comment[] = [];
    similar: Film[] | undefined;

    loader: boolean = false;
    page: number = 0;

    admin: boolean = false;
    registered: boolean = false;
    unregistered: boolean = false;

    fieldText: String = "";

    constructor(private router: Router, private activatedRouter: ActivatedRoute, private commentService: CommentService, 
        private service: FilmsService, private loginService: LoginService) {

        if (this.loginService.isLogged()) {
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
        const id = this.activatedRouter.snapshot.params['id'];
        this.update(id);
    }

    update(id: number | undefined) {
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

    deleteFilm() {
        this.service.deleteFilm(this.film.id);
    }

    deleteComment(comment: Comment) {
        this.commentService.deleteComment(comment.id).subscribe(
            _ => this.update(this.film.id)
        )
    }

    filmImage(film: Film) {
        return this.service.downloadImage(film);
    }

    loadMoreComments() {
        this.loader = true;
        this.page += 1;
        this.service.moreComments(this.page, this.film.id).subscribe(
            response => {
                response.content.forEach(comment => { 
                    this.comments.push(comment); 
                });
                this.loader = false;
            },
            error => {
                console.log(error);
                this.loader = false;
            }
        )
    }

    logout(){
        this.loginService.logOut();
        this.router.navigate(['/']);
    }
}