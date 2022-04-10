import { Film } from '../film.model';

export class FilmsList {
    private recommendations?: Array<Film>;

    private trending: Array<Film>;
    private action: Array<Film>;
    private adventure: Array<Film>;
    private animation: Array<Film>;
    private comedy: Array<Film>;
    private drama: Array<Film>;
    private horror: Array<Film>;
    private scifi: Array<Film>;

    constructor(/*recommendations: Array<Film>, */trending: Array<Film>, action: Array<Film>, adventure: Array<Film>, 
        animation: Array<Film>, comedy: Array<Film>, drama: Array<Film>, horror: Array<Film>, scifi: Array<Film>) {
            //this.recommendations = recommendations;
            this.trending = trending;
            this.action = action;
            this.adventure = adventure;
            this.animation = animation;
            this.comedy = comedy;
            this.drama = drama;
            this.horror = horror;
            this.scifi = scifi;
    }

    getTrending() {
        return this.trending;
    }
}