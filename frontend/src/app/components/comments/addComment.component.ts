import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './addComment.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css', '../../../assets/css/jquery.rateyo.component.css'],
})

export class AddComment implements OnInit {

    film!: Film;
    user!: User;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}