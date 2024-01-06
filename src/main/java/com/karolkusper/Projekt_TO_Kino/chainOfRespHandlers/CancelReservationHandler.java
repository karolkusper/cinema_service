package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.CancelReservationCommand;
import com.karolkusper.Projekt_TO_Kino.command.CancelReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class CancelReservationHandler extends BaseHandler {
    private final CinemaService cinemaService;
    public CancelReservationHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter reservation id: ");
        int id = scanner.nextInt();
        new CancelReservationsCommand(cinemaService,id).execute();

    }
}