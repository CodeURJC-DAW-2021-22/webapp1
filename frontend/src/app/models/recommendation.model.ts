import { Film } from "./film.model";

export interface Recommendation {
    id: number;
    film: Film;
}