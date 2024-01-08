package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.DateTimeValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.AddReservationCommand;
import com.karolkusper.Projekt_TO_Kino.command.AddScreeningCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Date;
import java.util.Scanner;


public class AddReservationHandler extends BaseHandler{
    private final CinemaService cinemaService;


    public AddReservationHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        int screeningId;
        int seat;
        int rowNumber;
        String name;
        String email;

        Scanner scanner = new Scanner(System.in);
        TextValidator textValidator = TextValidator.getInstance();
        IntegerValidator integerValidator = IntegerValidator.getInstance();


        System.out.println("Fill in information about reservation:");
        System.out.println("Screening Id: ");
        screeningId=integerValidator.validate(scanner);
        System.out.println("seat:");
        seat=integerValidator.validate(scanner);
        System.out.println("row:");
        rowNumber=integerValidator.validate(scanner);
        System.out.println("Your name:");
        name=textValidator.validate(scanner);
        System.out.println("Your email:");
        email=textValidator.validate(scanner);


        new AddReservationCommand(cinemaService,screeningId,seat,rowNumber,name,email).execute();

        super.handleRequest();

    }
}
