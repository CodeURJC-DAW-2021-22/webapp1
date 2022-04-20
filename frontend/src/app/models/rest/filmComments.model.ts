import { Comment } from "../comment.model";
import { Film } from "../film.model";
import { Page } from "./page.model";

export interface FilmComments {
    film: Film;
    comments: Page<Comment>;
}