import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Film } from "src/app/models/film.model";
import { FilmsList } from "src/app/models/rest/filmsList.model";
import { Page } from "src/app/models/rest/page.model";
import { FilmsService } from "src/app/services/film.service";


@Component({
    templateUrl: './menuAdmin.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class MenuAdmin implements OnInit {

    // Template elements
    filmsList!: FilmsList;
    trending: Film[] = [];
    action: Film[] = [];
    adventure: Film[] = [];
    animation: Film[] = [];
    comedy: Film[] = [];
    drama: Film[] = [];
    horror: Film[] = [];
    scifi: Film[] = [];

    token: any;

    // Spinners
    loaderTrending: boolean = false;
    loaderAction: boolean = false;
    loaderAdventure: boolean = false;
    loaderAnimation: boolean = false;
    loaderComedy: boolean = false;
    loaderDrama: boolean = false;
    loaderHorror: boolean = false;
    loaderScifi: boolean = false;
    
    // Index for pages
    indexTrendig: number = 0;
    indexAction: number = 0;
    indexAdventure: number = 0;
    indexAnimation: number = 0;
    indexComedy: number = 0;
    indexDrama: number = 0;
    indexHorror: number = 0;
    indexScifi: number = 0;

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
        return this.service.downloadImage(film);
    }

    loadMore(index: String) {
        this.loaderTrending = true;
        let value = this.searchIndex(index); 

        this.service.moreFilms(value).subscribe(
            response => this.insertFilms(response, index),
            error => console.log(error)
        );
    }

    loadMoreGenre(index: String, genre: String) {
        this.searchSpinner(index, true);
        let value = this.searchIndex(index); 

        this.service.moreFilmsGenre(genre, value).subscribe(
            response => this.insertFilms(response, index),
            error => console.log(error)
        );
    }

    insertFilms(response: Page<Film>, index: String) {
        let value = this.searchList(index);

        if (response != null) {
            response.content.forEach( (film) => {
                value.push(film);
            });
        }        

        this.searchSpinner(index, false);
    }

    searchIndex(index: String) {
        let value = 0;
        switch (index) {
            case ("indexTrending"):
                this.indexTrendig += 1;
                value = this.indexTrendig;
                break;
            case ("indexAction"):
                this.indexAction += 1;
                value = this.indexAction;
                break;
            case ("indexAdventure"):
                this.indexAdventure += 1;
                value = this.indexAdventure;
                break;
            case ("indexAnimation"):
                this.indexAnimation += 1;
                value = this.indexAnimation;
                break;
            case ("indexComedy"):
                this.indexComedy += 1;
                value = this.indexComedy;
                break;
            case ("indexDrama"):
                this.indexDrama += 1;
                value = this.indexDrama;
                break;               
            case ("indexHorror"):
                this.indexHorror += 1;
                value = this.indexHorror;
                break;
            case ("indexScifi"):
                this.indexScifi += 1;
                value = this.indexScifi;
                break;                  
        }
        return value;
    }

    searchList(index: String) {
        let value: Film[] = [];
        switch (index) {
            case ("indexTrending"):
                value = this.trending;
                break;
            case ("indexAction"):
                value = this.action;
                break;
            case ("indexAdventure"):
                value = this.adventure;
                break;
            case ("indexAnimation"):
                value = this.animation;
                break;
            case ("indexComedy"):
                value = this.comedy;
                break;
            case ("indexDrama"):
                value = this.drama;
                break;               
            case ("indexHorror"):
                value = this.horror;
                break;
            case ("indexScifi"):
                value = this.scifi;
                break;                  
        }

        return value;
    }

    searchSpinner(index: String, value: boolean) {
        switch (index) {
            case ("indexTrending"):
                this.loaderTrending = value;
                break;
            case ("indexAction"):
                this.loaderAction = value;
                break;
            case ("indexAdventure"):
                this.loaderAdventure = value;
                break;
            case ("indexAnimation"):
                this.loaderAnimation = value;
                break;
            case ("indexComedy"):
                this.loaderComedy = value;
                break;
            case ("indexDrama"):
                this.loaderDrama = value;
                break;               
            case ("indexHorror"):
                this.loaderHorror = value;
                break;
            case ("indexScifi"):
                this.loaderScifi = value;
                break;                  
        }
    }

}