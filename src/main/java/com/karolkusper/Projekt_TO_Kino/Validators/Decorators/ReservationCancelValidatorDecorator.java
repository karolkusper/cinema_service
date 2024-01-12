package com.karolkusper.Projekt_TO_Kino.Validators.Decorators;

import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.Validator;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ReservationCancelValidatorDecorator extends BaseDecorator<Integer> {
    private final CinemaService cinemaService;
    private final Scanner scanner;

    public ReservationCancelValidatorDecorator(Validator<Integer> validator, CinemaService cinemaService, Scanner scanner) {
        super(validator);
        this.cinemaService = cinemaService;
        this.scanner = scanner;
    }

    public String validateEmail() {
        String enteredEmail;
        boolean isEmailValid;
        TextValidator textValidator = TextValidator.getInstance();
        do {
            enteredEmail = textValidator.validate(scanner);
            isEmailValid = isEmailInReservations(enteredEmail);
            if (!isEmailValid) {
                System.out.println("Email not found in reservations. Enter a valid email:");
            }
        } while (!isEmailValid);
        return enteredEmail;
    }

    public int validateReservationId(String email) {
        int enteredReservationId;
        boolean isReservationIdValid;
        do {
            enteredReservationId = super.validate(scanner);
            isReservationIdValid = isReservationIdInReservations(enteredReservationId, email);
            if (!isReservationIdValid) {
                System.out.println("Reservation with this ID does not exist or does not belong to the specified email. Enter a valid reservation ID:");
            }
        } while (!isReservationIdValid);
        return enteredReservationId;
    }

    private boolean isEmailInReservations(String email) {
        List<Reservation> reservationsByEmail = cinemaService.getReservationsByEmail(email);
        return !reservationsByEmail.isEmpty();
    }

    private boolean isReservationIdInReservations(int reservationId, String email) {
        Optional<Reservation> reservationOptional = cinemaService.getReservationById(reservationId);
        return reservationOptional.isPresent() && reservationOptional.get().getClientEmail().equals(email);
    }
}
