package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;
import com.karolkusper.Projekt_TO_Kino.command.AddScreeningCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;


public class AddScreeningHandler extends BaseHandler{
    private final CinemaService cinemaService;

    public AddScreeningHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        new AddScreeningCommand(cinemaService).execute();

    }
}
