import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, throwError } from "rxjs";
import { Page } from "../models/rest/page.model";
import { UserComments } from "../models/rest/userComments.model";
import { User } from "../models/user.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root' })
export class UserService {

    constructor(private httpClient: HttpClient) { }

    getUser(id: number): Observable<UserComments> {
        return this.httpClient.get(BASE_URL + '/' + id).pipe(
        ) as Observable<UserComments>;
    }

    getMe(): Observable<UserComments> {
        return this.httpClient.get(BASE_URL + '/me', { withCredentials: true }
        ) as Observable<UserComments>;
    }

    register(formData: FormData) {
        return this.httpClient.post(BASE_URL + "/", formData);
    }

    downloadImage(user: User) {
        return user.image ? 'api/users/' + user.id + '/image' : 'assets/images/defaultImage.png';
    }

    moreComments(page: number, id: number) {
        return this.httpClient.get(BASE_URL + '/' + id + '/comments?page=' + page).pipe(
        ) as Observable<Page<Comment>>;
    }

    editProfile(id: number, formData: FormData) {
        return this.httpClient.patch(BASE_URL + '/' + id, formData, { withCredentials: true })
            .pipe(
                catchError(error => this.handleError(error))
            );
    }

    editImage(id: number, formData: FormData) {
        return this.httpClient.put(BASE_URL + '/' + id + '/image', formData, { withCredentials: true })
            .pipe(
                catchError(error => this.handleError(error))
            );
    }

    editPassword(id: number, formData: FormData) {
        return this.httpClient.patch(BASE_URL + '/' + id + '/password', formData, { withCredentials: true })
        .pipe(
            catchError(error => this.handleError(error))
        );
    }

    followers(page: number, id: number) {
        return this.httpClient.get(BASE_URL + '/' + id + '/followers?page=' + page).pipe(
        ) as Observable<Page<User>>;
    }

    following(page: number, id: number) {
        return this.httpClient.get(BASE_URL + '/' + id + '/following?page=' + page).pipe(
        ) as Observable<Page<User>>;
    }

    followUnfollow(id: number) {
        return this.httpClient.get(BASE_URL + '/' + id + '/followed', { withCredentials: true });
    }

    private handleError(error: any) {
        console.log("ERROR:");
        console.error(error);
        return throwError("Server error (" + error.status + "): " + error.text())
    }
}