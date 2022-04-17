import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

// AddFilm
import { AddFilm } from './components/add/addFilm.component';
import { AddComment } from './components/add/addComment.component';

// Films
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';
import { FilmRegisteredComponent } from './components/films/filmRegistered.component';

// Menu
import { FilmListAdviceMeComponent } from './components/menu/filmListAdviceMe.component';
import { MenuRegistered } from './components/menu/menuRegistered.component';
import { MenuAdmin } from './components/menu/menuAdmin.component';

// User
import { LoginComponent } from './components/user/login.component';
import { RegisterComponent } from './components/user/register.component';
import { EditComment } from './components/user/editComment.component';

@NgModule({
  declarations: [AppComponent, 
    AddFilm, AddComment,
    FilmUnregisteredComponent, FilmRegisteredComponent, 
    FilmListAdviceMeComponent, MenuRegistered, MenuAdmin,
    LoginComponent, RegisterComponent, EditComment],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
