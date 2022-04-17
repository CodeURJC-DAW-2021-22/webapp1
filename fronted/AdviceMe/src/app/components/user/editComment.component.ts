import { Component, OnInit } from "@angular/core";
import { Comment } from "src/app/models/comment.model";
import { User } from "src/app/models/user.model";


@Component({
    templateUrl: './editComment.html',
    styleUrls: ['../css/style.component.css', '../css/jquery.rateyo.component.css'],
})

export class EditComment implements OnInit {

    comment!: Comment;
    user!: User;
    token: any;
    
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

}