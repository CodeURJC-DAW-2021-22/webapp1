import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Comment } from "src/app/models/comment.model";
import { UserComments } from "src/app/models/rest/userComments.model";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './profile.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class ProfileComponent {
    
    userComments!: UserComments;
    user!: User;
    comments: Comment[] = []

    constructor(private loginService: LoginService, private userService: UserService, private router: Router) {
        this.userService.getMe().subscribe(
            response => {
                this.userComments = response;
                this.user = this.userComments.user;
                this.comments = this.userComments.comments.content;
            },
            error => this.router.navigate(['/login'])
        );
    }

    logOut() {
        this.loginService.logOut();
    }
}