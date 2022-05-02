import { Component, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Film } from "src/app/models/film.model";
import { Genre } from "src/app/models/genre.model";
import { FilmsService } from "src/app/services/film.service";
import { LoginService } from "src/app/services/login.service";

@Component({
    templateUrl: './addFilm.component.html',
    styleUrls: ['../../../assets/css/style.component.css'],
})

export class AddFilm {

    newFilm!: boolean;
    film!: Film;

    @ViewChild("file")
    file: any;

    fieldText: String = "";

    constructor(private loginService: LoginService, private router: Router,
        private activatedRoute: ActivatedRoute, private filmService: FilmsService) {
        
        const id = this.activatedRoute.snapshot.params['id'];

        if (id) {
            filmService.getFilm(id).subscribe(
                film => this.film = film.film,
                error => console.error(error)
            );

            this.newFilm = false;
        } else {
            let date: Date = new Date(1970, 1, 1);
            let genre: Genre = Genre.ACTION;
            this.film = {
                title: '', releaseDate: date, minAge: 'Minimum age', genre: genre, duration: 0,
                cast: '', director: '', plot: '', image: false
            };
            this.newFilm = true;
        }
    }

    save() {
        this.filmService.addFilm(this.film).subscribe(
            (film: Film) => this.uploadImage(film),
             error => alert('Error uploading new film: ' + error)
        );
    }

    uploadImage(film: Film): void {
        const image = this.file.nativeElement.files[0];

        if (image) {
            let formData = new FormData();
            formData.append("imageFile", image);
            
            if (this.newFilm) {
                this.filmService.uploadImage(film, formData).subscribe(
                    _ => this.afterUploadImage(film),
                    error => alert('Error uploading film image: ' + error)
                );
            } else {
                this.filmService.editImage(film, formData).subscribe(
                    _ => this.afterUploadImage(film),
                    error => alert('Error editing film image: ' + error)
                );
            }
        } else {
            this.afterUploadImage(film);
        }
    }

    private afterUploadImage(film: Film) {
        this.router.navigate(['/films/', film.id]);
    }

    logout() {
        this.loginService.logOut();
    }
}