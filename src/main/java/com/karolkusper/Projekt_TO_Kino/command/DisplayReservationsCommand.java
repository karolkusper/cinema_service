package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.console.AdminMenu;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.List;

public class DisplayReservationsCommand implements Command{
    private final List<Reservation> reservations;

    public DisplayReservationsCommand(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public void execute() {
        AdminMenu.displayReservations(reservations);
    }
}
