import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmsList } from 'src/app/models/rest/filmsList.model';
import { Film } from '../../models/film.model';
import { FilmsService } from './../../services/film.service';

@Component({
    templateUrl: './adviceMe.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class FilmListAdviceMeComponent implements OnInit {
    
    filmsList!: FilmsList;
    trending: Film[] = [];
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
        this.trending = this.filmsList.trending.content;
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