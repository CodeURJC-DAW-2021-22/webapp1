import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';
import { Router } from '@angular/router';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

    logged!: boolean;
    user: User | undefined;

    constructor(private router: Router, private http: HttpClient) {
        this.reqIsLogged();
    }

    reqIsLogged() {

        this.http.get('/api/users/me', { withCredentials: true }).subscribe(
            response => {
                this.user = response as User;
                this.logged = true;
                this.router.navigate(['/menuRegistered']);
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );

    }

    logIn(username: string, password: string) {

        this.http.post(BASE_URL + "/login", { username: username, password: password }, { withCredentials: true })
            .subscribe(
                (response) => this.reqIsLogged(),
                (error) => alert("Wrong credentials")
            );

    }

    logOut() {

        return this.http.post(BASE_URL + '/logout', { withCredentials: true })
            .subscribe((resp: any) => {
                console.log("LOGOUT: Successfully");
                this.logged = false;
                this.user = undefined;
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
