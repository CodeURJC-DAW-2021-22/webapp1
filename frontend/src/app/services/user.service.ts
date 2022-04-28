import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from 'rxjs/operators';

import { User } from "../models/user.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root'})
export class UserService {
    
    registered!: boolean;
    user: User | undefined;

    constructor(private httpClient: HttpClient) {  
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
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );

    }

    register(formData: FormData) {
        return this.httpClient.post(BASE_URL + "/", formData, { withCredentials: true }).pipe(
            catchError(error => this.handleError(error))
        );
    }

    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

    /*isRegistered() {
        return this.registered;
    }*/
}