import { Component } from "@angular/core";
import { LoginService } from "src/app/services/login.service";

@Component({
    selector : 'login',
    templateUrl: './login.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class LoginComponent{

    username!: string;
    password!: string;

    constructor(private loginService: LoginService) { }

    logIn() {
        this.loginService.logIn(this.username, this.password);
    }
}