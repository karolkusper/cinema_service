package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.Decorators.ReservationCancelValidatorDecorator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.CancelReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsClientCommand;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.List;
import java.util.Scanner;

public class CancelReservationClientHandler extends BaseHandler {
    private final CinemaService cinemaService;
    public CancelReservationClientHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        Scanner scanner = new Scanner(System.in);
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        ReservationCancelValidatorDecorator reservationCancelValidatorDecorator = new ReservationCancelValidatorDecorator(integerValidator,cinemaService,scanner);

        System.out.println("Enter your email:");
        String email = reservationCancelValidatorDecorator.validateEmail();

        List<Reservation> reservationsByEmail = cinemaService.getReservationsByEmail(email);

        new DisplayReservationsClientCommand(reservationsByEmail).execute();

        System.out.println("Enter id of reservation that you want to cancel:");
        int reservationId= reservationCancelValidatorDecorator.validateReservationId(email);

       new CancelReservationsCommand(cinemaService,reservationId).execute();

        System.out.printf("Reservation of id="+reservationId+" was deleted!");

        super.handleRequest();

    }
}
