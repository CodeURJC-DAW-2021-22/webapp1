import { Film } from '../film.model';
import { Page } from './page.model';

export interface FilmsList {
    recommendations?: Page<Film>;
    trending: Page<Film>;
    action: Page<Film>;
    adventure: Page<Film>;
    animation: Page<Film>;
    comedy: Page<Film>;
    drama: Page<Film>;
    horror: Page<Film>;
    scifi: Page<Film>;
}