import { Component, OnInit } from "@angular/core";

declare var showPassword: any;
@Component({
    templateUrl: './register.component.html',
    styleUrls: ['../css/style.component.css','../css/styleLogin.component.css']
})

export class RegisterComponent implements OnInit {

    token: any;
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    showPassword() {
        new showPassword();
    }
}