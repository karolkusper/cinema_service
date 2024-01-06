package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class MakeReservationCommand implements Command{
    private CinemaService cinemaService;
    public MakeReservationCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.makeReservation();
    }
}
