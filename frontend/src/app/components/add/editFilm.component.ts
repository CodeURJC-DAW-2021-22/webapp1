import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";

@Component({
    templateUrl: './editFilm.html',
    styleUrls: ['../css/style.component.css'],
})

export class EditFilm implements OnInit {

    film!: Film;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
}