import { Film } from "./film.model";
import { User } from "./user.model";

export interface Comment {
    id?: number;
    stars: number;
    note: string;
    film: Film;
    user: User;
}