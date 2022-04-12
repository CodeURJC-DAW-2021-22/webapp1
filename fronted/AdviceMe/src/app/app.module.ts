import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { FilmListAdviceMeComponent } from './components/films/filmListAdviceMe.component';
import { FilmUnregisteredComponent } from './components/films/filmUnregistered.component';
@NgModule({
  declarations: [AppComponent, FilmListAdviceMeComponent, FilmUnregisteredComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
