import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Comment } from "src/app/models/comment.model";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './watchProfile.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class WatchProfileComponent implements OnInit {

    // Control of headers
    admin: boolean = false;
    registered: boolean = false;

    fieldText: String = "";

    userWatch!: User;
    comments: Comment[] = [];

    token: any;

    loaderCommentWatchProfile: boolean = false;

    constructor(private router: Router, private loginService: LoginService) {
        if (this.loginService.isLogged()){
            if (this.loginService.isAdmin()) {
                this.admin = true;
            } else {
                this.registered = true;
            }
        }   
    }

    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    loadMoreComments() {
        
    }
}