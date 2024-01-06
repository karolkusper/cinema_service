package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ShowFilmDetailsCommand implements Command{
    private CinemaService cinemaService;
    int filmId;
    public ShowFilmDetailsCommand(CinemaService cinemaService,int filmId) {
        this.cinemaService=cinemaService;
        this.filmId=filmId;
    }

    @Override
    public void execute() {
        cinemaService.showFilmDetails(filmId);
    }
}
