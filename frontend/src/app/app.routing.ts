import { RouterModule } from '@angular/router';

// Comments
import { AddComment } from './components/comments/addComment.component';
import { EditComment } from './components/comments/editComment.component';

// Films
import { AddFilm } from './components/films/addFilm.component';
import { EditFilm } from './components/films/editFilm.component';
import { FilmAdminComponent } from './components/films/filmAdmin.component';
import { FilmRegisteredComponent } from './components/films/filmRegistered.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';
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
    { path: 'film/:idFilm/addComment', component: AddComment },
    { path: 'editComment/:idComment', component: EditComment },

    // Films
    { path: 'addFilm', component: AddFilm },
    { path: 'editFilm', component: EditFilm },
    { path: 'filmAdmin/:id', component: FilmAdminComponent },
    { path: 'filmRegistered/:id', component: FilmRegisteredComponent },
    { path: 'films/:id', component: FilmUnregisteredComponent },
    { path: 'searchFilms/:query', component: SearchFilmsComponent },

    // Login
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },

    // Menu
    { path: 'adviceMe', component: MenuComponent },

    // Users
    { path: 'editPassword', component: EditPassword },
    { path: 'editProfile', component: EditProfile },
    { path: 'followers', component: FollowersComponent },
    { path: 'following', component: FollowingComponent },
    { path: 'profile/:id', component: ProfileComponent },
    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes, { anchorScrolling: 'enabled' });