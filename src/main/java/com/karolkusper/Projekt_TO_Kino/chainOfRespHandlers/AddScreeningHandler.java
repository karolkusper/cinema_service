package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.DateTimeValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.FloatValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;
import com.karolkusper.Projekt_TO_Kino.command.AddScreeningCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import com.karolkusper.Projekt_TO_Kino.Validators.Decorators.AddScreeningValidatorDecorator;

import java.util.Date;
import java.util.Scanner;

public class AddScreeningHandler extends BaseHandler {
    private final CinemaService cinemaService;

    public AddScreeningHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        Scanner scanner = new Scanner(System.in);
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        DateTimeValidator dateTimeValidator = DateTimeValidator.getInstance();
        AddScreeningValidatorDecorator screeningValidator = new AddScreeningValidatorDecorator(integerValidator, cinemaService, scanner);

        System.out.println("Enter filmId:");
        int filmId = screeningValidator.validateFilmId();
        System.out.println("Enter date and time (yyyy-MM-dd HH:mm):");
        Date dateAndTime = dateTimeValidator.validate(scanner);
        System.out.println("Enter hall (A-D):");
        String hall = screeningValidator.validateHall();

        // Dodatkowa metoda sprawdzająca dostępność godziny dla seansu
        boolean isScreeningTimeAvailable = screeningValidator.isScreeningTimeAvailable(dateAndTime, hall);

        if (isScreeningTimeAvailable) {
            new AddScreeningCommand(cinemaService, filmId, dateAndTime, hall).execute();
            System.out.println("Screening added successfully!");
        } else {
            System.out.println("Screening time is not available. Please choose a different date and time.");
        }

        super.handleRequest();
    }
}
