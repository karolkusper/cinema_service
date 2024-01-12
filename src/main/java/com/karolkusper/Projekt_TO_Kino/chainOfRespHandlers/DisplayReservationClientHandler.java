package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsClientCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayReservationsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;


public class DisplayReservationClientHandler extends BaseHandler{
    private final CinemaService cinemaService;


    public DisplayReservationClientHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {
        TextValidator textValidator = TextValidator.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter your email: ");
        String email=textValidator.validate(scanner);
        new DisplayReservationsClientCommand(cinemaService.getReservationsByEmail(email)).execute();

        super.handleRequest();

    }
}
