import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { User } from "src/app/models/user.model";
import { Router, ActivatedRoute } from '@angular/router';
import { CommentService } from "src/app/services/comment.service";
import { FilmsService } from "src/app/services/film.service";

@Component({
    templateUrl: './addComment.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css', '../../../assets/css/jquery.rateyo.component.css'],
})

export class AddComment implements OnInit {

    film!: Film;
    user!: User;
    comment!: Comment;
    note!: string;
    stars!: number; 
    newComment!: boolean;
    
    constructor(private router: Router, private activatedRouter: ActivatedRoute, private service: CommentService, private filmService: FilmsService) {
    }

    ngOnInit(): void {
        const idFilm = this.activatedRouter.snapshot.params['idFilm'];
        const idComment = this.activatedRouter.snapshot.params['idComment'];
        if(idFilm){
            this.filmService.getFilm(idFilm).subscribe(
                response => this.film = response.film,
                error => console.log(error)
            )
            this.newComment = true;
        } else {
            this.service.getComment(idComment).subscribe(
                response => this.comment = response,
                error => console.log(error)
            )
            this.newComment = false;
        }
    }

    filmImage(film: Film) {
        return this.filmService.downloadImage(film);
    }

    //addComment, editComment

    save(idComment: number){
        if(this.newComment){
            this.filmService.addComment(this.film.id, this.note, this.stars);
        } else {
            this.service.editComment(idComment, this.note, this.stars);
        }
    }
    
}