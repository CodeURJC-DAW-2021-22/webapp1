import { Comment } from "../comment.model";
import { Film } from "../film.model";

export interface FilmComments {
    film:Film;
    comments: Array<Comment>;
}