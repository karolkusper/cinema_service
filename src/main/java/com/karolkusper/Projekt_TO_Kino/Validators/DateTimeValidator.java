package com.karolkusper.Projekt_TO_Kino.Validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTimeValidator implements Validator<Date> {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String INVALID_TIME_MESSAGE = "Invalid time. Screenings are only allowed every 3 hours starting from 10:00.";
    private static final String INVALID_FORMAT_MESSAGE = "Invalid date and time format. Use " + DATE_FORMAT_PATTERN + ".";
    private static final String FUTURE_DATE_MESSAGE = "The date and time must be in the future.";

    private static DateTimeValidator instance;
    private final SimpleDateFormat dateFormat;

    private DateTimeValidator() {
        dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
    }

    // Konstruktor ułatwiający testowanie
    public DateTimeValidator(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public static synchronized DateTimeValidator getInstance() {
        if (instance == null) {
            instance = new DateTimeValidator();
        }
        return instance;
    }

    private boolean isFutureDateTime(Date dateTime) {
        Date currentDate = new Date();
        return dateTime.after(currentDate);
    }

    @Override
    public Date validate(Scanner scanner) {
        boolean isValidDateTime = false;
        Date dateTime = null;

        while (!isValidDateTime) {
            // Wczytaj datę i godzinę
            System.out.println("Enter date and time (" + DATE_FORMAT_PATTERN + ") Screenings are only allowed every 3 hours starting from 10:00: ");
            String input = scanner.nextLine();

            // Spróbuj sparsować datę i godzinę
            try {
                dateTime = dateFormat.parse(input);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateTime);

                // Sprawdź, czy godzina jest pełną godziną i co 3 godziny
                if (calendar.get(Calendar.MINUTE) == 0 && (calendar.get(Calendar.HOUR_OF_DAY) - 10) % 3 == 0) {
                    // Sprawdź, czy data i godzina są z przyszłości
                    if (isFutureDateTime(dateTime)) {
                        isValidDateTime = true;
                    } else {
                        System.out.println(FUTURE_DATE_MESSAGE);
                    }
                } else {
                    System.out.println(INVALID_TIME_MESSAGE);
                }
            } catch (ParseException e) {
                System.out.println(INVALID_FORMAT_MESSAGE);
            }
        }

        return dateTime;
    }
}
