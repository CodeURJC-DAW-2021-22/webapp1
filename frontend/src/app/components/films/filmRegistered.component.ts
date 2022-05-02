import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { Film } from "src/app/models/film.model";
import { FilmComments } from "src/app/models/rest/filmComments.model";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { Router } from "@angular/router";

@Component({
    templateUrl: './filmRegistered.component.html',
    styleUrls: ['../../../assets/css/appFilm.component.css', '../../../assets/css/themeFilm.component.css',
    '../../../assets/css/jquery.rateyo.component.css', '../../../assets/css/loadingButton.component.css',]
})

export class FilmRegisteredComponent implements OnInit {

    filmComments!: FilmComments;
    film!: Film;
    comments!: Comment[];
    similar!: Film[];
    visible: boolean = true;
    user!: User;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    constructor(private router: Router, private loginService: LoginService){}

    logout(){
        this.loginService.logOut();
        this.router.navigate(['/']);
    }

}