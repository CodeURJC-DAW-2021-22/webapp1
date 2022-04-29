import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UserComments } from "../models/rest/userComments.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root'})
export class UserService {

    constructor(private httpClient: HttpClient) { }

    getUser(id: number): Observable<UserComments>{
        return this.httpClient.get(BASE_URL + '/' + id).pipe(
        ) as Observable<UserComments>;
    }

    getMe(): Observable<UserComments> {
        return this.httpClient.get(BASE_URL + '/me', { withCredentials: true }
        ) as Observable<UserComments>;
    }

    register(formData: FormData) {
        return this.httpClient.post(BASE_URL + "/", formData, { withCredentials: true });
    }
}