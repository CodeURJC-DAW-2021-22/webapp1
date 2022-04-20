import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmsService } from '../../services/film.service';
import { Film, } from '../../models/film.model';

@Component({
  templateUrl: './filmForm.component.html'
})

export class FilmFormComponent {

  newFilm: boolean = false;
  film!: Film;

  @ViewChild("file")
  file: any;

  removeImage: boolean = false;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private service: FilmsService) {

    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      service.getFilm(id).subscribe(
        film => this.film = film,
        error => console.error(error)
      );
      this.newFilm = false;
    } else {
      //this.film = { title: '', plot: '', image: false };
      this.newFilm = true;
    }
  }

  cancel() {
    window.history.back();
  }
  
  save() {/*
    if(this.film.image && this.removeImage){
      this.film.image = false;
    }
    this.service.addFilm(this.film).subscribe(
      (film: Film) => this.uploadImage(film),
      error => alert('Error creating new film: ' + error)
    );*/
  }

  uploadImage(film: Film): void {/*

    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.service.setFilmImage(film, formData).subscribe(
        _ => this.afterUploadImage(film),
        error => alert('Error uploading book image: ' + error)
      );
    } else if(this.removeImage){
      this.service.deleteFilmImage(film).subscribe(
        _ => this.afterUploadImage(film),
        error => alert('Error deleting book image: ' + error)
      );
    } else {
      this.afterUploadImage(film);
    }*/
  }

  private afterUploadImage(film: Film){
    this.router.navigate(['/films/', film.id]);
  }

  bookImage() {
    return this.film.image ? '/api/films/' + this.film.id + '/image' : '/assets/images/no_image.png';
  }
}