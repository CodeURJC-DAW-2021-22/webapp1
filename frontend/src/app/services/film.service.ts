import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { FilmsList } from '../models/rest/filmsList.model';
import { Film } from '../models/film.model';
import { Comment } from '../models/comment.model';
import { Page } from '../models/rest/page.model';
import { FilmComments } from '../models/rest/filmComments.model';
import { Router } from '@angular/router';

const BASE_URL = '/api/films';

@Injectable({ providedIn: 'root' })
export class FilmsService {

	constructor(private httpClient: HttpClient, private router: Router) { }

	getMenu(): Observable<FilmsList> {
		return this.httpClient.get(BASE_URL + '/menu', { withCredentials: true }).pipe(
		) as Observable<FilmsList>;
	}

	getFilm(id: number): Observable<FilmComments> {
		return this.httpClient.get(BASE_URL + '/' + id).pipe(
		) as Observable<FilmComments>;
	}

	getChartData(): Observable<number[]> {
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

	deleteFilm(id: number) {
		this.httpClient.delete(BASE_URL + '/' + id).subscribe(
			response => this.router.navigate(['/menuAdmin']),
			error => this.handleError(error)
		);
	}

	addComment(id: number, note: string, stars: number) {
		return this.httpClient.post(BASE_URL + '/' + id + '/comments', { note: note, stars: stars }, { withCredentials: true }).subscribe(
			response => this.router.navigate(['/filmRegistered/', id]),
			error => {
				if (error.status == 403) {
					alert('You have already commented in this film.');
				} else {
					this.handleError(error);
				}
			}
		)
	}

	downloadImage(film: Film) {
		return film.image ? '/api/films/' + film.id + '/image' : '/assets/images/no_image.png';
	}

	moreComments(page: number, id: number) {
		return this.httpClient.get(BASE_URL + id + '/comments?page=' + page).pipe(
		) as Observable<Page<Comment>>;
	}

	moreFilms(page: number) {
		return this.httpClient.get(BASE_URL + '/?page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

	moreFilmsGenre(genre: String, page: number) {
		return this.httpClient.get(BASE_URL + '/?genre=' + genre + '&page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

	moreFilmsRecommendations(page: number) {
		return this.httpClient.get(BASE_URL + 'recommendations' + '/?page=' + page).pipe(
		) as Observable<Page<Film>>;
	}

	private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

}