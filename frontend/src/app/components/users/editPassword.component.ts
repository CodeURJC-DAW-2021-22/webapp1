import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { UserComments } from "src/app/models/rest/userComments.model";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './editPassword.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class EditPassword {

    user!: User;

    userComments!: UserComments;
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
            response => {
                this.userComments = response;
                this.user = this.userComments.user;
            }
        );
    }

    save() {
        let formData = new FormData();
        formData.append("oldPassword", this.password);
        formData.append("newPassword", this.newPassword);
        this.userService.editPassword(this.user.id, formData).subscribe(
            response => this.router.navigate(['/account']),
            error => alert('Error updating password')
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