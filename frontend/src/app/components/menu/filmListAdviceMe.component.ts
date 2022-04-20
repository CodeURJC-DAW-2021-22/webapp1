import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmsList } from 'src/app/models/rest/filmsList.model';
import { Film } from '../../models/film.model';
import { FilmsService } from './../../services/film.service';

@Component({
    templateUrl: './adviceMe.html',
    styleUrls: ['../css/style.component.css', '../css/loadingButton.component.css'],
})

export class FilmListAdviceMeComponent implements OnInit {
    
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
    
    constructor(private router: Router, private service: FilmsService){ }

    ngOnInit() {
        this.service.getFilms().subscribe(
            response => this.update(response),
            error => console.log(error)
        );
    }

    update(response:FilmsList) {
        this.filmsList = response;
        
    }

    // Pruebas para que funcione bien la API
    update1(response: FilmsList) {
        this.filmsList = response;
        /*const obj = Object.values(this.filmsList.trending);
        console.log(obj[0]);
        this.array = obj[0];
        this.array.forEach(element => {
            console.log();
        });
        this.trendingList = this.filmsList.trending;
        //console.log(this.trendingList);


        this.page = this.trendingList[4].title;
        console.log(this.page);*/
    }
}