import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './addComment.html',
    styleUrls: ['../css/appFilm.component.css', '../css/themeFilm.component.css', '../css/jquery.rateyo.component.css'],
})

export class AddComment implements OnInit {

    film!: Film;
    user!: User;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}