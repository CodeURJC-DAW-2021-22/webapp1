import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { FilmsList } from '../models/rest/filmsList.model';
import { Film } from '../models/film.model';
import { Page } from '../models/rest/page.model';
import { FilmComments } from '../models/rest/filmComments.model';
import { exists } from 'fs';

const BASE_URL = '/api/films';

@Injectable({ providedIn: 'root'})
export class FilmsService {

    constructor(private httpClient: HttpClient) { }

    getMenu(): Observable<FilmsList> {
        return this.httpClient.get(BASE_URL + '/menu', { withCredentials: true }).pipe(
        ) as Observable<FilmsList>;
    }

	getFilm(id: number): Observable<FilmComments>{
        return this.httpClient.get(BASE_URL + '/' +id).pipe(
        ) as Observable<FilmComments>;
    }

	getChartData(): Observable<number[]>{
        return this.httpClient.get(BASE_URL + '/comments/number').pipe(
        ) as Observable<number[]>;
    }

    addFilm(film: Film) {
		if (!film.id) {
			return this.httpClient.post(BASE_URL, film)
				.pipe(
					catchError(error => this.handleError(error))
				);
		} else {
			return this.httpClient.put(BASE_URL + film.id, film).pipe(
				catchError(error => this.handleError(error))
			);
		}
	}

	deleteFilm(film: Film) {
		this.httpClient.delete(BASE_URL + film.id).subscribe(
			response => this.getMenu,
			error => this.handleError(error)
		);
	}

	addComment(film: Film, comment: Comment){
		return this.httpClient.put(BASE_URL ).subscribe(
			response => this.getFilm(film.id),
			error  => this.handleError(error)
		)
	}

	downloadImage(film: Film) {
		return film.image? '/api/films/'+ film.id + '/image' : '/assets/images/no_image.png';
	}

	moreFilms(page: number) {
		return this.httpClient.get(BASE_URL + '/?page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

	moreFilmsGenre(genre: String, page: number) {
		return this.httpClient.get(BASE_URL + '/?genre=' + genre +'&page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

	moreFilmsRecommendations(page: number) {
		return this.httpClient.get(BASE_URL + 'recommendations' +'/?page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

}