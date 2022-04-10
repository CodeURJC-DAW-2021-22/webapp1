import {Comment} from "./comment.model";
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

    comments: Array<Comment>;

    imageFile: Blob;

    image: boolean;

    similar: Array<Film>;
}