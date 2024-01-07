package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class AddFilmCommand implements Command{
    CinemaService cinemaService;
    String title;
    String director;
    int releaseYear;
    float rating;

    public AddFilmCommand(CinemaService cinemaService, String title, String director, int releaseYear, float rating) {
        this.cinemaService = cinemaService;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public void execute() {
        cinemaService.addFilm(title,director,releaseYear,rating);
    }
}
