import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './profile.html',
    styleUrls: ['../css/style.component.css', '../css/loadingButton.component.css'],
})

export class ProfileComponent implements OnInit {

    user!: User;
    comments: Comment[] = []
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}