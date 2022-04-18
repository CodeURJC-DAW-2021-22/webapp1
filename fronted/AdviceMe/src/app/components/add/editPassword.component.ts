import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

declare var showPassword: any;
@Component({
    templateUrl: './editPassword.html',
    styleUrls: ['../css/style.component.css', '../css/styleLogin.component.css'],
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