package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class CancelReservationCommand implements Command{
    private CinemaService cinemaService;
    private int reservationId;
    public CancelReservationCommand(CinemaService cinemaService ,int reservationId) {
        this.cinemaService=cinemaService;
        this.reservationId=reservationId;
    }
    @Override
    public void execute() {
        cinemaService.cancelReservation(reservationId);
    }
}
