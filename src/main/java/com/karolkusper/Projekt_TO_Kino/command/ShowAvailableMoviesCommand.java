package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ShowAvailableMoviesCommand implements Command{
    private CinemaService cinemaService;
    public ShowAvailableMoviesCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.showAvailableMovies();
    }
}
