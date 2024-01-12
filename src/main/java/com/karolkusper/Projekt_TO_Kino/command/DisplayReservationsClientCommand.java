package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.console.ClientMenu;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.List;

public class DisplayReservationsClientCommand implements Command{
    private List<Reservation> reservations;

    public DisplayReservationsClientCommand(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public void execute() {
        ClientMenu.displayClientReservations(reservations);
    }
}
