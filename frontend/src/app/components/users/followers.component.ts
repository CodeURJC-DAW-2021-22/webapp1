import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './followers.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class FollowersComponent implements OnInit {

    user!: User;
    followers: User[] = []
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}