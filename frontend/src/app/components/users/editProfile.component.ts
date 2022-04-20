import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './editProfile.component.html',
    styleUrls: ['../../../assets/css/style.component.css'],
})

export class EditProfile implements OnInit {

    user!: User;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
}