import { Component } from "@angular/core";
import { LoginService } from "src/app/services/login.service";
//import { Router } from '@angular/router';

@Component({
    selector : 'login',
    templateUrl: './login.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class LoginComponent{

    username!: string;
    password!: string;

    constructor(private loginService: LoginService, /*private router: Router*/) { 
        /*if(this.loginService.isLogged()){
            this.router.navigate(['/menuRegistered']);
        }*/
    }

    logIn() {
        this.loginService.logIn(this.username, this.password);
    }
}