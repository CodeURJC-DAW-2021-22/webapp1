import { Comment } from "./Comment";
import { Recommendation } from "./Recommendation";

export interface User {
    id?: number;
    name: string;
    email: string;

    comments: Array<Comment>;

    encodedPassword: string;

    roles: Array<string>;

    imageFile: Blob;
    image: boolean;

    following: Array<User>;
    followingCount: number;

    followers: Array<User>;
    followesCount: number;

    recommentdations: Array<Recommendation>
}