import { Component, OnInit } from "@angular/core";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";
import { ActivatedRoute, Router } from '@angular/router';

declare var showPassword: any;
@Component({
    templateUrl: './register.component.html',
    styleUrls: ['../../../assets/css/style.component.css','../../../assets/css/styleLogin.component.css']
})

export class RegisterComponent implements OnInit {

    username!: string;
    email!:  string;
    password!:  string;

    token: any;
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    constructor(public loginService: LoginService, private router: Router,
        activatedRoute: ActivatedRoute, private userService: UserService){}

    register(){
        const formData = new FormData();
        formData.append('name', this.username);
        formData.append('email', this.email);
        formData.append('password', this.password);
        this.userService.register(formData);
    }

    showPassword() {
        new showPassword();
    }
}