import { Comment } from "./comment.model";
import { Recommendation } from "./recommendation.model";

export interface User {
    id?: number;
    name: string;
    email: string;

    comments?: Array<Comment>;

    encodedPassword: string;

    roles: Array<string>;

    imageFile: Blob;
    image: boolean;

    following?: Array<User>;
    followingCount: number;

    followers?: Array<User>;
    followersCount: number;

    recommendations: Array<Recommendation>
}