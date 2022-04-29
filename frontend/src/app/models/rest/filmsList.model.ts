import { Film } from '../film.model';
import { Recommendation } from '../recommendation.model';
import { Page } from './page.model';

export interface FilmsList {
    recommendations: Page<Recommendation>;
    trending: Page<Film>;
    action: Page<Film>;
    adventure: Page<Film>;
    animation: Page<Film>;
    comedy: Page<Film>;
    drama: Page<Film>;
    horror: Page<Film>;
    scifi: Page<Film>;
}