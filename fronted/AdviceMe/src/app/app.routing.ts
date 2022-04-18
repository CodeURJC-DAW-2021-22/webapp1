import { RouterModule } from '@angular/router';

import { FilmListAdviceMeComponent} from './components/films/filmListAdviceMe.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/login/register.component';

const appRoutes = [
    // Films
    { path: 'adviceMe', component: FilmListAdviceMeComponent},
    { path: 'films/:id', component: FilmUnregisteredComponent},

    // User
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent},
    
    // El siguiente es para borrar, es una prueba
    { path: 'filmsUnregistered', component: FilmUnregisteredComponent},
    
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);