import { Routes, RouterModule } from '@angular/router';

import { FilmListAdviceMeComponent} from './components/films/filmListAdviceMe.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';

import { LoginComponent } from './components/user/login.component';

const appRoutes = [
    { path: 'adviceMe', component: FilmListAdviceMeComponent},
    { path: 'films/:id', component: FilmUnregisteredComponent},
    { path: 'login', component: LoginComponent},
    
    // El siguiente es para borrar, es una prueba
    { path: 'filmsUnregistered', component: FilmUnregisteredComponent},
    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);