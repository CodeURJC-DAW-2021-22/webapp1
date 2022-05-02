import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { User } from "src/app/models/user.model";
import { Router, ActivatedRoute } from '@angular/router';
import { CommentService } from "src/app/services/comment.service";
import { FilmsService } from "src/app/services/film.service";
import { Comment } from 'src/app/models/comment.model';
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './addComment.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css', '../../../assets/css/jquery.rateyo.component.css'],
})

export class AddComment implements OnInit {

    newComment!: boolean;

    film!: Film;
    comment!: Comment;
    
    note: string = "";
    stars: number = 0;
    

    constructor(private router: Router, private activatedRouter: ActivatedRoute, private service: CommentService,
        private filmService: FilmsService, private loginService: LoginService) {

        if (!this.loginService.isLogged()) {
            this.router.navigate(['/login']);
        }
    }

    ngOnInit(): void {
        const idFilm = this.activatedRouter.snapshot.params['idFilm'];
        const idComment = this.activatedRouter.snapshot.params['idComment'];

        if (idComment) {
            this.service.getComment(idComment).subscribe(
                response => {
                    this.comment = response;
                    this.film = this.comment.film;
                    this.note = this.comment.note;
                    this.stars = this.comment.stars;
                },
                error => console.log(error)
            )

            this.newComment = false;
        } else {
            this.filmService.getFilm(idFilm).subscribe(
                response => this.film = response.film,
                error => console.log(error)
            )
            
            this.newComment = true;
        }
    }

    filmImage() {
        return this.filmService.downloadImage(this.film);
    }

    save() {
        if (this.newComment) {
            this.filmService.addComment(this.film.id, this.note, this.stars);
        } else {
            this.service.editComment(this.comment, this.note, this.stars);
        }
    }
}