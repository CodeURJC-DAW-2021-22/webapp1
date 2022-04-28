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

// Login
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/login/register.component';

// Menu
import { FilmListAdviceMeComponent} from './components/menu/filmListAdviceMe.component';
import { MenuAdmin } from './components/menu/menuAdmin.component';
import { MenuRegistered } from './components/menu/menuRegistered.component';

// Users
import { EditPassword } from './components/users/editPassword.component';
import { EditProfile } from './components/users/editProfile.component';
import { FollowersComponent } from './components/users/followers.component';
import { FollowingComponent } from './components/users/following.component';
import { ProfileComponent } from './components/users/profile.component';

const appRoutes = [
    // Comments
    { path: 'addComment', component: AddComment },
    { path: 'editComment', component: EditComment },

    // Films
    { path: 'addFilm', component: AddFilm },
    { path: 'editFilm', component: EditFilm },
    { path: 'filmAdmin', component: FilmAdminComponent },
    { path: 'filmRegistered', component: FilmRegisteredComponent },
    { path: 'films/:id', component: FilmUnregisteredComponent },

    // Login
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },

    // Menu
    { path: 'adviceMe', component: FilmListAdviceMeComponent },
    { path: 'menuAdmin', component: MenuAdmin },
    { path: 'menuRegistered', component: MenuRegistered },

    // Users
    { path: 'editPassword', component: EditPassword },
    { path: 'editProfile', component: EditProfile },
    { path: 'followers', component: FollowersComponent },
    { path: 'following', component: FollowingComponent },
    { path: 'profile', component: ProfileComponent },
    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes, { anchorScrolling: 'enabled' });