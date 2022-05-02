import { Component, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "src/app/models/user.model";
import { LoginService } from "src/app/services/login.service";
import { UserService } from "src/app/services/user.service";

@Component({
    templateUrl: './editProfile.component.html',
    styleUrls: ['../../../assets/css/style.component.css'],
})

export class EditProfile {

    user!: User;
    email!: string;

    @ViewChild("file")
    file: any;

    fieldText: String = "";

    constructor(private userService: UserService, private router: Router, private loginService: LoginService) {

        if (!this.loginService.isLogged()) {
            this.router.navigate(['/login']);
        }

        this.userService.getMe().subscribe(
            response => {
                this.user = response.user;
                this.email = this.user.email;
            }
        );
    }

    save() {
        let formData = new FormData();
        formData.append("newEmail", this.email);
        this.userService.editProfile(this.user.id, formData).subscribe(
            _ => this.uploadImage(),
            _ => alert('Error updating user profile')
        );
    }

    uploadImage() {
        const image = this.file.nativeElement.files[0];
        
        if (image) {
          let formData = new FormData();
          formData.append("imageFile", image);
          this.userService.editImage(this.user.id, formData).subscribe(
            _ => this.afterUploadImage(),
            _ => alert('Error uploading user image')
          );
        } else {
          this.afterUploadImage();
        }
    }

    private afterUploadImage() {
        this.router.navigate(['/account']);
    }
}