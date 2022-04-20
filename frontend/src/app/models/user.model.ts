export interface User {
    id?: number;
    name: string;
    email: string;
    roles: string[];
    image: boolean;
    followingCount: number;
    followersCount: number;
}