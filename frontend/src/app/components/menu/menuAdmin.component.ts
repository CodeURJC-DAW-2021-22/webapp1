import { Component, OnInit } from "@angular/core";
import { Film } from "src/app/models/film.model";
import { FilmsList } from "src/app/models/rest/filmsList.model";


@Component({
    templateUrl: './menuAdmin.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class MenuAdmin implements OnInit {

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
    
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}