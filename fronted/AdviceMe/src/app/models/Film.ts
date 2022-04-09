import {Comment} from "./Comment";
import {Genre} from "./Genre";

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

    comments: Array<Comment>;

    imageFile: Blob;

    image: boolean;

    similar: Array<Film>;
}