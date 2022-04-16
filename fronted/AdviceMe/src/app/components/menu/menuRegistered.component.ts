import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { FilmsList } from "src/app/models/rest/filmsList.model";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './menuRegistered.html',
    styleUrls: ['../css/style.component.css', '../css/loadingButton.component.css'],
})

export class MenuRegistered implements OnInit {

    filmsList!: FilmsList;
    //trending: Film[] = [];
    trending: string[] = ["Película 1", "Película 2"]
    action: Film[] = [];
    adventure: Film[] = [];
    animation: Film[] = [];
    comedy: Film[] = [];
    drama: Film[] = [];
    horror: Film[] = [];
    scifi: Film[] = [];
    
    user!: User;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}