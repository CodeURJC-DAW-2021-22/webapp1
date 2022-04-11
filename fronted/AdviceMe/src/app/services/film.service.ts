import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Film } from '../models/film.model';
import { FilmsList } from '../models/rest/filmsList.model';

const BASE_URL = '/api/films';

@Injectable({ providedIn: 'root'})
export class FilmService {
    constructor(private httpClient: HttpClient) { }

    getFilms(): Observable<FilmsList> {
        return this.httpClient.get(BASE_URL + '/menu').pipe(
        ) as Observable<FilmsList>;
    }
}