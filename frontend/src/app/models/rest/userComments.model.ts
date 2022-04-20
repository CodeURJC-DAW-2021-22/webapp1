import { Comment } from "../comment.model";
import { User } from "../user.model";

export interface userComments {
    user: User;
    commets: Array<Comment>
}