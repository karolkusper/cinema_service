package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;
import com.karolkusper.Projekt_TO_Kino.command.ShowAvailableScreeningsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ShowAvailableScreeningsHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public ShowAvailableScreeningsHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        new ShowAvailableScreeningsCommand(cinemaService).execute();

    }
}
