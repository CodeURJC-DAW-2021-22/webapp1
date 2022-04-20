import {Genre} from "./genre.model";

export interface Film {
    id?: number;
    title: string;
    releaseDate: Date;
    averageStars: number;
    minAge: string;
    genre: Genre;
    duration: number;
    cast: string;
    director: string;
    plot: string;
    image: boolean;
    similar: Array<Film>;
}