package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.ShowAvailableMoviesCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ShowAvailableMoviesHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public ShowAvailableMoviesHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        System.out.println("These are movies that are currently played: ");
        new ShowAvailableMoviesCommand(cinemaService).execute();

        super.handleRequest();

    }
}
