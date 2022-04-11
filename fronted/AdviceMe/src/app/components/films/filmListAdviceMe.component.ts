import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmsList } from 'src/app/models/rest/filmsList.model';
import { Film } from '../../models/film.model';
import { FilmService } from './../../services/film.service';

@Component({
    templateUrl: './films-adviceMe.html'
})

export class FilmListAdviceMeComponent implements OnInit {
    
    filmsList!: FilmsList;
    trendingList!: Film[];
    page!: string;

    constructor(private router: Router, private service: FilmService){ }

    ngOnInit() {
        this.service.getFilms().subscribe(
            response => this.update(response),
            error => console.log(error)
        );
    }

    update(response: FilmsList) {
        this.filmsList = response;
        this.trendingList = this.filmsList.trending;
        console.log(this.trendingList);
        this.page = this.trendingList[4].title;
        console.log(this.page);
    }
}