import { Component, OnInit } from "@angular/core";
import { LoginService } from "src/app/services/login.service";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector : 'login',
    templateUrl: './login.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class LoginComponent implements OnInit {

    logged: boolean = false;
    token: any;
    ngOnInit(): void {
        this.logged = this.loginService.isLogged();
        if (this.logged){
            this.router.navigate(['/menuRegistered']);
        }
    }

    constructor(public loginService: LoginService, private router: Router,
        activatedRoute: ActivatedRoute) { }

    logIn(event: any, user: string, password: string) {
  
      event.preventDefault();
  
      this.loginService.logIn(user, password);
    }
}