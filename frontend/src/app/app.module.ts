import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { AppComponent } from './app.component';
import { routing } from './app.routing';

// Comments
import { AddComment } from './components/comments/addComment.component';
import { EditComment } from './components/comments/editComment.component';

// Films
import { AddFilm } from './components/films/addFilm.component';
import { EditFilm } from './components/films/editFilm.component';
import { FilmFormComponent } from './components/films/filmForm.component';
import { FilmAdminComponent } from './components/films/filmAdmin.component';
import { FilmRegisteredComponent } from './components/films/filmRegistered.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';

// Login
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/login/register.component';

// Menu
import { FilmListAdviceMeComponent } from './components/menu/filmListAdviceMe.component';
import { MenuAdmin } from './components/menu/menuAdmin.component';
import { MenuRegistered } from './components/menu/menuRegistered.component';

// Users
import { EditPassword } from './components/users/editPassword.component';
import { EditProfile } from './components/users/editProfile.component';
import { FollowersComponent } from './components/users/followers.component';
import { FollowingComponent } from './components/users/following.component';
import { ProfileComponent } from './components/users/profile.component';

@NgModule({
  declarations: [AppComponent, 
    AddComment, EditComment,
    AddFilm, EditFilm, FilmFormComponent, FilmAdminComponent, FilmRegisteredComponent, FilmUnregisteredComponent,
    LoginComponent, RegisterComponent,
    FilmListAdviceMeComponent, MenuAdmin, MenuRegistered,
    EditPassword, EditProfile, FollowersComponent, FollowingComponent, ProfileComponent],
  imports: [BrowserModule, BrowserAnimationsModule, FormsModule, HttpClientModule, routing, NgbModule, NgxChartsModule],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
