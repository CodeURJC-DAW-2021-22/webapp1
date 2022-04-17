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
import { EditComment } from './components/user/editComment.component';

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
    { path: 'addFilm', component: AddFilm},
    { path: 'addComment', component: AddComment},
    { path: 'editComment', component: EditComment},

    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);