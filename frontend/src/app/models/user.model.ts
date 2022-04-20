import { Comment } from "./comment.model";
import { Recommendation } from "./recommendation.model";

export interface User {
    id?: number;
    name: string;
    email: string;
    roles: string[];
    image: boolean;
    followingCount: number;
    followersCount: number;
}