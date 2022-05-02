import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Comment } from "src/app/models/comment.model";
import { UserComments } from "src/app/models/rest/userComments.model";
import { User } from "src/app/models/user.model";
import { CommentService } from "src/app/services/comment.service";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './profile.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class ProfileComponent {
    
    account!: boolean;
    userComments!: UserComments;
    user!: User;
    comments: Comment[] = []

    followBtn: String = "Follow";
    loader: boolean = false;
    page: number = 0;

    fieldText: String = "";

    constructor(private loginService: LoginService, private userService: UserService, private commentService: CommentService, private router: Router, 
        private activatedRouter: ActivatedRoute) {

        if (!this.loginService.isLogged()) {
            this.router.navigate(['/login']);
        }

        const id = this.activatedRouter.snapshot.params['id'];
        let currentUser = this.loginService.currentUser();
        
        if (!id) {
            this.update();
        } else {
            if (currentUser && currentUser.id == id) {
                this.router.navigate(['/account']);
            }
            this.userService.getUser(id).subscribe(
                response => {
                    this.userComments = response;
                    this.user = this.userComments.user;
                    this.comments = this.userComments.comments.content;
                    this.account = false;
                },
                error => console.log(error)
            );
        }
    }

    update() {
        this.userService.getMe().subscribe(
            response => {
                this.userComments = response;
                this.user = this.userComments.user;
                this.comments = this.userComments.comments.content;
                this.account = true;
            }
        );
    }

    profileImage() {
        return this.userService.downloadImage(this.user);
    }

    removeComment(id: number) {
        this.commentService.deleteComment(id).subscribe(
            _ => this.update()
        );
    }

    moreComments() {
        this.loader = true;
        this.page += 1;

        this.userService.moreComments(this.user.id, this.page).subscribe(
            response => {
                response.content.forEach(comment => {
                    this.comments.push(comment);
                });

                this.loader = false;
            },
            error =>  {
                console.log(error);
                this.loader = false;
            }
        );
    }

    logOut() {
        this.loginService.logOut();
        this.router.navigate(['/']);
    }

    follow() {
        this.userService.followUnfollow(this.user.id).subscribe(
            response => {
                this.user = response;

                if (this.followBtn == "Follow") {
                    this.followBtn = "Unfollow";
                } else {
                    this.followBtn = "Follow";
                }
            },
            error => console.log(error)
        )
    }
}