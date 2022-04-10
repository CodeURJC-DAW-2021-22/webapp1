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
    trendingList: Film[] = [];

    constructor(private router: Router, private service: FilmService){ }

    ngOnInit() {
        this.service.getFilms().subscribe(
            filmsList => this.filmsList = filmsList,
            error => console.log(error)
        );
        this.trendingList = this.filmsList.getTrending();
    }
}