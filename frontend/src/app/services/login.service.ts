import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { UserService } from "src/app/services/user.service";
import { Observable } from 'rxjs';
import { UserComments } from '../models/rest/userComments.model';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

    logged!: boolean;
    user: User | undefined;

    constructor(private http: HttpClient, private router: Router, private userService: UserService) {
        this.userService.getMe().subscribe(
            response => {
                this.user = response.user;
                this.logged = true;
            },
            error => console.log(error)
        );
    }

    logIn(username: string, password: string) {
        return this.http.post(BASE_URL + "/login", { username: username, password: password }, { withCredentials: true }).subscribe(
            _ => this.router.navigate(['/']),
            _ => alert("Wrong credentials")
        );
    }

    logOut() {
        return this.http.post(BASE_URL + '/logout', { withCredentials: true }).subscribe(
            _ => {
                this.logged = false;
                this.user = undefined;
                this.router.navigate(['/']);
            });
    }

    isLogged() {
        return this.userService.getMe().pipe(
        ) as Observable<UserComments>;
    }

    isAdmin() {
        return this.user && this.user.roles.indexOf('ADMIN') !== -1;
    }

    currentUser() {
        return this.user;
    }
}