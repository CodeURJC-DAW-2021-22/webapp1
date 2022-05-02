import { Component } from "@angular/core";
import { UserService } from "src/app/services/user.service";
import { Router } from '@angular/router';

@Component({
    templateUrl: './register.component.html',
    styleUrls: ['../../../assets/css/style.component.css','../../../assets/css/styleLogin.component.css']
})

export class RegisterComponent {

    username!: string;
    email!:  string;
    password!:  string;

    passVisible: boolean= false;

    constructor(private router: Router, private userService: UserService) { }

    register(){
        const formData = new FormData();
        formData.append('name', this.username);
        formData.append('email', this.email);
        formData.append('password', this.password);
        
        this.userService.register(formData).subscribe(
            _ => this.router.navigate(['/login']),
            _ => alert("Username already exists")
        );
    }

    showPassword(){
        if (this.passVisible == true) {
            this.passVisible = false;
        } else {
            this.passVisible = true;
        }
    }
}