package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class DisplayReservationsCommand implements Command{
    private CinemaService cinemaService;
    public DisplayReservationsCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.displayReservations();
    }
}
