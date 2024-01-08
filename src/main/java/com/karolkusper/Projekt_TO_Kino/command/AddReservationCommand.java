package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Date;

public class AddReservationCommand implements Command{
    CinemaService cinemaService;
    int screeningId;
    int seat;
    int row;
    String name;
    String email;

    public AddReservationCommand(CinemaService cinemaService, int screeningId, int seat, int row, String name, String email) {
        this.cinemaService = cinemaService;
        this.screeningId = screeningId;
        this.seat = seat;
        this.row = row;
        this.name = name;
        this.email = email;
    }

    @Override
    public void execute() {
        cinemaService.addReservation(screeningId,seat,row,name,email);
    }
}
