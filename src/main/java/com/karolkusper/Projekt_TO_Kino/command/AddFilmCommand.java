package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class AddFilmCommand implements Command{
    CinemaService cinemaService;
    public AddFilmCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.addFilm();
    }
}
