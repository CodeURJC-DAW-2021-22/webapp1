import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './following.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/loadingButton.component.css'],
})

export class FollowingComponent implements OnInit {

    user!: User;
    followings: User[] = []
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}