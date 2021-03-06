import { RouterModule } from '@angular/router';

// Comments
import { AddComment } from './components/comments/addComment.component';

// Films
import { AddFilm } from './components/films/addFilm.component';
import { FilmComponent } from './components/films/film.component';
import { SearchFilmsComponent } from './components/films/searchFilms.component';

// Login
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/login/register.component';

// Menu
import { MenuComponent } from './components/menu/menu.component';

// Users
import { EditPassword } from './components/users/editPassword.component';
import { EditProfile } from './components/users/editProfile.component';
import { FollowersComponent } from './components/users/followers.component';
import { FollowingComponent } from './components/users/following.component';
import { ProfileComponent } from './components/users/profile.component';

const appRoutes = [
    // Comments
    { path: 'addComment/:idFilm', component: AddComment },
    { path: 'editComment/:idComment', component: AddComment },

    // Films
    { path: 'addFilm', component: AddFilm },
    { path: 'editFilm/:id', component: AddFilm },
    { path: 'films/:id', component: FilmComponent },
    { path: 'searchFilms/:query', component: SearchFilmsComponent },

    // Login
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },

    // Menu
    { path: 'adviceMe', component: MenuComponent },

    // Users
    { path: 'editPassword', component: EditPassword },
    { path: 'editProfile', component: EditProfile },
    { path: 'followers/:id', component: FollowersComponent },
    { path: 'following/:id', component: FollowingComponent },
    { path: 'profile/:id', component: ProfileComponent },
    { path: 'account', component: ProfileComponent },
    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes, { anchorScrolling: 'enabled' });