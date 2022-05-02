import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './editPassword.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class EditPassword {

    user!: User;

    password!: string;
    newPassword!: string; 

    fieldText: string = "";

    passVisible: boolean = false;
    newPassVisible: boolean = false;

    constructor(private userService: UserService, private activatedRouter: ActivatedRoute, private router: Router, private loginService: LoginService) {
        if (!this.loginService.isLogged()) {
            this.router.navigate(['/login']);
        }

        this.userService.getMe().subscribe(
            response => this.user = response.user
        );
    }

    save() {
        let formData = new FormData();
        formData.append("oldPassword", this.password);
        formData.append("newPassword", this.newPassword);
        this.userService.editPassword(this.user.id, formData).subscribe(
            _ => this.router.navigate(['/account']),
            _ => alert('Wrong password')
        )
    }

    showPassword(){
        if (this.passVisible == true) {
            this.passVisible = false;
        } else {
            this.passVisible = true;
        }
    }

    showNewPassword(){
        if (this.newPassVisible == true) {
            this.newPassVisible = false;
        } else {
            this.newPassVisible = true;
        }
    }
}