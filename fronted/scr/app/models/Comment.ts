import { Film } from "./Film";
import { User } from "./User";

export interface Comment {
    id?: number;
    starts: number;
    note: string;

    film: Film;
    user: User;
}