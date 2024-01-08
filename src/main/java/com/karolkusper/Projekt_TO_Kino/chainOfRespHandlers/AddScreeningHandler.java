package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.DateTimeValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.FloatValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;
import com.karolkusper.Projekt_TO_Kino.command.AddScreeningCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Date;
import java.util.Scanner;


public class AddScreeningHandler extends BaseHandler{
    private final CinemaService cinemaService;


    public AddScreeningHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        int filmId;
        Date dateAndTime;
        String hall;

        Scanner scanner = new Scanner(System.in);
        TextValidator textValidator = TextValidator.getInstance();
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        DateTimeValidator dateTimeValidator = DateTimeValidator.getInstance();

        System.out.println("Fill in information about screening.");
        System.out.println("Film Id: ");
        filmId=integerValidator.validate(scanner);
        System.out.println("Date and time:");
        dateAndTime=dateTimeValidator.validate(scanner);
        System.out.println("Hall:");
        hall=textValidator.validate(scanner);


        new AddScreeningCommand(cinemaService,filmId,dateAndTime,hall).execute();

        super.handleRequest();

    }
}
