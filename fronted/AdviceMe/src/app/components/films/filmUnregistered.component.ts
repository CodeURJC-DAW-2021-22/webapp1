import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/fillmComments.model";

@Component({
    templateUrl: './films-Unregistered.component.html',
    styleUrls: ['../css/appFilm.component.css', '../css/themeFilm.component.css', '../css/jquery.rateyo.component.css', '../css/loadingButton.component.css',]

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