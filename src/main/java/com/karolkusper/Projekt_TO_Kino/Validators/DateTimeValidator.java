package com.karolkusper.Projekt_TO_Kino.Validators;

import com.karolkusper.Projekt_TO_Kino.Validators.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTimeValidator implements Validator<Date> {

    private static DateTimeValidator instance;

    private final SimpleDateFormat dateFormat;

    private DateTimeValidator() {
        dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    }

    public static synchronized DateTimeValidator getInstance() {
        if (instance == null) {
            instance = new DateTimeValidator();
        }
        return instance;
    }

    @Override
    public Date validate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter date and time (dd.MM.yyyy HH:mm): ");
                String input = scanner.nextLine();
                return dateFormat.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid input. Please enter a valid date and time.");
            }
        }
    }
}
