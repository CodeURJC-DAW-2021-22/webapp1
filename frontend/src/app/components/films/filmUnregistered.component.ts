import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/filmComments.model";

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

    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
    
}