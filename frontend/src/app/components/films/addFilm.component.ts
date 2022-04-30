import { Component, OnInit } from "@angular/core";

@Component({
    templateUrl: './addFilm.component.html',
    styleUrls: ['../../../assets/css/style.component.css'],
})

export class AddFilm implements OnInit {

    token: any;
    fieldText: String = "";
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
}