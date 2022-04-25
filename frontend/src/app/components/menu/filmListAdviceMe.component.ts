import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genre } from 'src/app/models/genre.model';
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
        this.service.getMenu().subscribe(
            response => this.update(response),
            error => console.log(error)
        );
    }

    update(response:FilmsList) {
        this.filmsList = response;
        this.trending = this.filmsList.trending.content;
        this.action = this.filmsList.action.content;
        this.adventure = this.filmsList.adventure.content;
        this.animation = this.filmsList.animation.content;
        this.comedy = this.filmsList.comedy.content;
        this.drama = this.filmsList.drama.content;
        this.horror = this.filmsList.drama.content;
        this.scifi = this.filmsList.scifi.content;
    }

    filmImage (film: Film) {
        return film.image? '/api/films/'+ film.id + '/image' : '/assets/images/no_image.png';
    }

    loadMore(genre: String) {
        
    }
}