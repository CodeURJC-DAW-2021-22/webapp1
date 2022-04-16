import { Film } from "./film.model";
import { User } from "./user.model";

export interface Comment {
    id?: number;
    starts: number;
    note: string;

    film: Film;
    user: User;
}