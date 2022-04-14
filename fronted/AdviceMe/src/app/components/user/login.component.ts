import { Component, OnInit } from "@angular/core";

@Component({
    templateUrl: './login.html',
    styleUrls: ['../css/style.component.css','../css/styleLogin.component.css']
})

export class LoginComponent implements OnInit {

    token: any;
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}