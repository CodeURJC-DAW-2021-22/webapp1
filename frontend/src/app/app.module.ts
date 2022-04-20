import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

// AddFilm
import { AddFilm } from './components/add/addFilm.component';
import { EditFilm } from './components/add/editFilm.component';
import { AddComment } from './components/add/addComment.component';
import { EditComment } from './components/add/editComment.component';
import { EditPassword } from './components/add/editPassword.component';
import { EditProfile } from './components/add/editProfile.component';

// Films
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';
import { FilmRegisteredComponent } from './components/films/filmRegistered.component';
import { FilmAdminComponent } from './components/films/filmsAdmin.component';

// Menu
import { FilmListAdviceMeComponent } from './components/menu/filmListAdviceMe.component';
import { MenuRegistered } from './components/menu/menuRegistered.component';
import { MenuAdmin } from './components/menu/menuAdmin.component';

// User
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/login/register.component';
import { FollowersComponent } from './components/login/followers.component';
import { FollowingComponent } from './components/login/following.component';
import { ProfileComponent } from './components/login/profile.component';


@NgModule({
  declarations: [AppComponent, 
    AddFilm, EditFilm, AddComment, EditComment, EditPassword, EditProfile,
    FilmUnregisteredComponent, FilmRegisteredComponent, FilmAdminComponent,
    FilmListAdviceMeComponent, MenuRegistered, MenuAdmin,
    LoginComponent, RegisterComponent, FollowersComponent, FollowingComponent, ProfileComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
