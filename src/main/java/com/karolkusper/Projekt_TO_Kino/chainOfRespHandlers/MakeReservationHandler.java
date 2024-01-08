package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.MakeReservationCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class MakeReservationHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public MakeReservationHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        new MakeReservationCommand(cinemaService).execute();

        super.handleRequest();
    }
}
