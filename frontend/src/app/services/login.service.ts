import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';
import { UserComments } from '../models/rest/userComments.model';
import { Router } from '@angular/router';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

    logged!: boolean;
    userComments: UserComments | undefined;
    user: User | undefined;

    constructor(private http: HttpClient, private router: Router) {
        this.reqIsLogged();
    }

    reqIsLogged() {
        return this.http.get('/api/users/me', { withCredentials: true }).subscribe(
            response => {
                this.userComments = response as UserComments;
                this.user = this.userComments.user;
                this.logged = true;

                if (this.isLogged()) {
                    if (this.isAdmin()) {
                        this.router.navigate(['/menuAdmin']);
                    } else {
                        this.router.navigate(['/menuRegistered']);
                    }
                }
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );
    }

    logIn(username: string, password: string) {
        return this.http.post(BASE_URL + "/login", { username: username, password: password }, { withCredentials: true }).subscribe(
            response => {
                this.reqIsLogged();
            },
            error => alert("Wrong credentials")
        );
    }

    logOut() {
        return this.http.post(BASE_URL + '/logout', { withCredentials: true })
            .subscribe((resp: any) => {
                this.logged = false;
                this.user = undefined;
                this.userComments = undefined;
            });
    }

    isLogged() {
        return this.logged;
    }

    isAdmin() {
        return this.user && this.user.roles.indexOf('ADMIN') !== -1;
    }

    currentUser() {
        return this.user;
    }
}
