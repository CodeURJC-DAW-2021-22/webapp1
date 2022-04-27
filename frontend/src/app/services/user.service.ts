import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

import { Router, ActivatedRoute } from '@angular/router';

import { User } from "../models/user.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root'})
export class UserService {
    
    registered!: boolean;
    user: User | undefined;

    constructor(private router: Router, activatedRoute: ActivatedRoute, private httpClient: HttpClient) {  
        this.reqIsRegistered();     
    }

    getUser(id: number): Observable<User>{
        return this.httpClient.get(BASE_URL + id).pipe(
        ) as Observable<User>;
    }

    reqIsRegistered() {

        this.httpClient.get(BASE_URL + '/me', { withCredentials: true }).subscribe(
            
            response => {
                this.user = response as User;
                this.registered = true;
                this.router.navigate(['/api/auth/login']);
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );

    }

    register(formData: FormData) {

        this.httpClient.post(BASE_URL + "/", formData)
            .subscribe(
                (response) => this.reqIsRegistered(),
                (error) => alert("Wrong credentials")
            );

    }
}