import { Component, OnInit } from "@angular/core";
import { LoginService } from "src/app/services/login.service";

@Component({
    selector : 'login',
    templateUrl: './login.html',
    styleUrls: ['../css/style.component.css','../css/styleLogin.component.css'],
})

export class LoginComponent implements OnInit {

    token: any;
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    constructor(public loginService: LoginService) { }

    logIn(event: any, user: string, pass: string) {
  
      event.preventDefault();
  
      this.loginService.logIn(user, pass);
    }
  
    logOut() {
      this.loginService.logOut();
    }

}