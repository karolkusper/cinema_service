package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;


public class DisplayReservationHandler extends BaseHandler{
    private final CinemaService cinemaService;

    public DisplayReservationHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        new DisplayReservationsCommand(cinemaService).execute();

    }
}
