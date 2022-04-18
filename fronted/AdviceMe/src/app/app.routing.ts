import { RouterModule } from '@angular/router';

import { FilmListAdviceMeComponent} from './components/menu/filmListAdviceMe.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';
import { FilmRegisteredComponent } from './components/films/filmRegistered.component';

import { LoginComponent } from './components/user/login.component';
import { RegisterComponent } from './components/user/register.component';
import { MenuRegistered } from './components/menu/menuRegistered.component';
import { MenuAdmin } from './components/menu/menuAdmin.component';
import { AddFilm } from './components/add/addFilm.component';
import { AddComment } from './components/add/addComment.component';
import { EditComment } from './components/add/editComment.component';
import { EditFilm } from './components/add/editFilm.component';
import { EditPassword } from './components/add/editPassword.component';
import { EditProfile } from './components/add/editProfile.component';
import { FilmAdminComponent } from './components/films/filmsAdmin.component';
import { FollowersComponent } from './components/user/followers.component';
import { FollowingComponent } from './components/user/following.component';
import { ProfileComponent } from './components/user/profile.component';

const appRoutes = [
    // Add
    

    // Films
    { path: 'films/:id', component: FilmUnregisteredComponent},

    // User
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent},
    
    // Menu
    { path: 'adviceMe', component: FilmListAdviceMeComponent},
    { path: 'menuRegistered', component: MenuRegistered},
    { path: 'menuAdmin', component: MenuAdmin},

    // Los siguientes es para borrar, son pruebas
    { path: 'filmsUnregistered', component: FilmUnregisteredComponent},
    { path: 'filmsRegistered', component: FilmRegisteredComponent},
    { path: 'filmsAdmin', component: FilmAdminComponent},
    { path: 'addFilm', component: AddFilm},
    { path: 'addComment', component: AddComment},
    { path: 'editComment', component: EditComment},
    { path: 'editFilm', component: EditFilm},
    { path: 'editPassword', component: EditPassword},
    { path: 'editProfile', component: EditProfile},
    { path: 'followers', component: FollowersComponent},
    { path: 'following', component: FollowingComponent},
    { path: 'profile', component: ProfileComponent},

    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);