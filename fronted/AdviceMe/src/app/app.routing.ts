import { Routes, RouterModule } from '@angular/router';

import { FilmListAdviceMeComponent} from './components/films/filmListAdviceMe.component';

const appRoutes = [
    { path: 'adviceMe', component: FilmListAdviceMeComponent},
    { path: '', redirectTo: 'adviceMe', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);