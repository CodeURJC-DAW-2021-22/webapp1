import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './followers.html',
    styleUrls: ['../css/style.component.css', '../css/loadingButton.component.css'],
})

export class FollowersComponent implements OnInit {

    user!: User;
    followers: User[] = []
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}