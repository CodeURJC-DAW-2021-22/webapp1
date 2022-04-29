import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

import { User } from "../models/user.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root'})
export class UserService {
    
    user: User | undefined;

    constructor(private httpClient: HttpClient) { }

    getUser(id: number): Observable<User>{
        return this.httpClient.get(BASE_URL + id).pipe(
        ) as Observable<User>;
    }

    getMe() {
        this.httpClient.get(BASE_URL + '/me', { withCredentials: true }).subscribe(
            response => {
                this.user = response as User;
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );
    }

    register(formData: FormData) {
        return this.httpClient.post(BASE_URL + "/", formData, { withCredentials: true });
    }
}