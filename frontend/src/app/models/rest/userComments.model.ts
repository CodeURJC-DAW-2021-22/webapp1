import { Comment } from "../comment.model";
import { User } from "../user.model";
import { Page } from "./page.model";

export interface userComments {
    user: User;
    commets: Page<Comment>
}