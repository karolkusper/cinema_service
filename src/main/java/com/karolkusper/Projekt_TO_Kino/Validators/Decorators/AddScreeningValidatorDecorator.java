package com.karolkusper.Projekt_TO_Kino.Validators.Decorators;

import com.karolkusper.Projekt_TO_Kino.Validators.DateTimeValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.Validator;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddScreeningValidatorDecorator extends BaseDecorator<Integer> {
    private final CinemaService cinemaService;
    private final Scanner scanner;

    public AddScreeningValidatorDecorator(Validator<Integer> validator, CinemaService cinemaService, Scanner scanner) {
        super(validator);
        this.cinemaService = cinemaService;
        this.scanner = scanner;
    }

    public int validateFilmId() {
        int enteredFilmId;
        boolean isFilmIdValid;

        do {
            enteredFilmId = validator.validate(scanner);
            isFilmIdValid = cinemaService.isFilmExist(enteredFilmId);
            if (!isFilmIdValid) {
                System.out.println("Film with this ID does not exist. Enter a valid film ID:");
            }
        } while (!isFilmIdValid);
        return enteredFilmId;
    }


    public String validateHall() {
        String enteredHall;
        boolean isHallValid;
        TextValidator textValidator = TextValidator.getInstance();
        do {
            enteredHall = textValidator.validate(scanner);
            isHallValid = isValidHall(enteredHall);
            if (!isHallValid) {
                System.out.println("Invalid hall. Please enter A, B, C, or D:");
            }
        } while (!isHallValid);
        return enteredHall;
    }





    private boolean isValidHall(String hall) {
        return hall.matches("[A-D]");
    }

    // Additional method to check if a screening already exists at the given date, time, and hall
    public boolean isScreeningTimeAvailable(Date dateTime, String hall) {
        return cinemaService.isScreeningTimeAvailable(dateTime, hall);
    }
}
