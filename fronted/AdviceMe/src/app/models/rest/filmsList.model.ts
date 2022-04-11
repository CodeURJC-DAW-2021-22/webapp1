import { Film } from '../film.model';

export interface FilmsList {
    recommendations?: Array<Film>;

    trending: Array<Film>;
    action: Array<Film>;
    adventure: Array<Film>;
    animation: Array<Film>;
    comedy: Array<Film>;
    drama: Array<Film>;
    horror: Array<Film>;
    scifi: Array<Film>;



}