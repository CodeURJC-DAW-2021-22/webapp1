import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

declare var showPassword: any;

@Component({
    templateUrl: './editPassword.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class EditPassword implements OnInit {

    user!: User;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    showPassword() {
        new showPassword();
    }
}