import { Component, OnInit } from "@angular/core";
import { User } from "src/app/models/user.model";

@Component({
    templateUrl: './editPassword.component.html',
    styleUrls: ['../../../assets/css/style.component.css', '../../../assets/css/styleLogin.component.css'],
})

export class EditPassword implements OnInit {

    user!: User;
    token: any;
    fieldText: String = "";

    passVisible: boolean = false;
    newPassVisible: boolean = false;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
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