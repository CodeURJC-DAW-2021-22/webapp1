import { Component} from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { UserComments } from "src/app/models/rest/userComments.model";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './followers.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class FollowersComponent {

    user!: User;
    userComments!: UserComments;
    followersList: User[] = [];
    
    loader: boolean = false;
    page: number = 0;

    constructor(private userService: UserService, private loginService: LoginService, private router: Router, private activatedRouter: ActivatedRoute) {

        if (!this.loginService.isLogged()) {
            this.router.navigate(['/login']);
        }

        this.userService.getUser(this.activatedRouter.snapshot.params['id']).subscribe(
            response => {
                this.userComments = response;
                this.user = this.userComments.user;
                this.userService.followers(this.user.id, 0).subscribe(
                    response => {
                        this.followersList = response.content;
                    },
                    error =>  {
                        console.log(error);
                    }
                )
            },
            error =>  {
                console.log(error);
            }
        );
        
    }

    followers() {
        this.loader = true;
        this.page += 1;

        this.userService.followers(this.user.id, this.page).subscribe(
            response => {
                response.content.forEach(user => {
                    this.followersList.push(user);
                });

                this.loader = false;
            },
            error =>  {
                console.log(error);
                this.loader = false;
            }
        );
    }


}