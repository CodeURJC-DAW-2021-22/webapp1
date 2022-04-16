import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/fillmComments.model";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './films-Registered.html',
    styleUrls: ['../css/appFilm.component.css', '../css/themeFilm.component.css', '../css/jquery.rateyo.component.css', '../css/loadingButton.component.css',]

})
export class FilmRegisteredComponent implements OnInit {

    filmComments!: FilmComments;
    film!: Film;
    comments!: Comment[];
    similar!: Film[];
    buttonHidden: boolean = false;
    user!: User;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}