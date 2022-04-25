import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { FilmsList } from '../models/rest/filmsList.model';
import { Film } from '../models/film.model';

const BASE_URL = '/api/films';

@Injectable({ providedIn: 'root'})
export class FilmsService {

    constructor(private httpClient: HttpClient) { }

    getMenu(): Observable<FilmsList> {
        return this.httpClient.get(BASE_URL + '/menu').pipe(
        ) as Observable<FilmsList>;
    }
    
    getFilm(id: number): Observable<Film>{
        return this.httpClient.get(BASE_URL + id).pipe(
        ) as Observable<Film>;
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

    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}
}