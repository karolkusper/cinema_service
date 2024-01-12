package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.command.CancelReservationCommand;
import com.karolkusper.Projekt_TO_Kino.command.CancelReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Optional;
import java.util.Scanner;

public class CancelReservationHandler extends BaseHandler {
    private final CinemaService cinemaService;
    public CancelReservationHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        Scanner scanner = new Scanner(System.in);
        IntegerValidator integerValidator = IntegerValidator.getInstance();

        System.out.println("Enter reservation id: ");
        int id = integerValidator.validate(scanner);
        Optional<Reservation> reservationOptional = cinemaService.getReservationById(id);
        if(reservationOptional.isEmpty())
        {
            System.out.println("There is no reservation with this id in database!");
            return;
        }
        new CancelReservationsCommand(cinemaService,id).execute();

        System.out.printf("Reservation of id="+id+" was deleted!");

        super.handleRequest();

    }
}
