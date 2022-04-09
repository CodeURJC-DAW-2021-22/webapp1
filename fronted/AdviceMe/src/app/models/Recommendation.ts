import { Film } from "./Film";

export interface Recommendation {
    id?: number;
    filmRecommended: Film;
}