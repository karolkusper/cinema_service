package com.karolkusper.Projekt_TO_Kino.Validators.Decorators;

import com.karolkusper.Projekt_TO_Kino.Validators.Validator;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReservationValidationDecorator extends BaseDecorator<Integer>{
    Scanner scanner;
    CinemaService service;


    public ReservationValidationDecorator(Validator<Integer> validator, Scanner scanner, CinemaService service) {
        super(validator);
        this.scanner = scanner;
        this.service = service;
    }

    public Integer validateScreeningId(){
        Integer enteredId;
        boolean isScreeningExists;
        do {
            enteredId=super.validate(scanner);
            isScreeningExists=service.isScreeningExist(enteredId);
            if(!isScreeningExists)
            {
                System.out.println("Screening with this id does not exists! Enter valid screening id:");
            }
        }while (!isScreeningExists);
        return enteredId;
    }

    public Map<Integer, Integer> validateSeatAndRow(int screeningId) {
        Map<Integer, Integer> selectedSpot = null;
        boolean isValidSpot;

        do {
            int seat;
            int rowNumber;


            // Wczytaj od użytkownika rowNumber w poprawnym zakresie (1-10)
            do {
                System.out.print("Enter row number (1-10): ");
                rowNumber = super.validate(scanner);

                if (!isValidRange(rowNumber)) {
                    System.out.println("Row number must be in the range of 1-10.");
                }

            } while (!isValidRange(rowNumber));

            // Wczytaj od użytkownika seat w poprawnym zakresie (1-10)
            do {
                System.out.print("Enter seat number (1-10): ");
                seat = super.validate(scanner);

                if (!isValidRange(seat)) {
                    System.out.println("Seat number must be in the range of 1-10.");
                }

            } while (!isValidRange(seat));


            // Sprawdź, czy seat i row są wolne
            Map<Integer, List<Integer>> takenSpots = service.getTakenSpots(screeningId);

            isValidSpot = isSpotValid(seat, rowNumber, takenSpots);

            if (!isValidSpot) {
                System.out.println("Selected spot is not available. Please choose another spot.");
            } else {
                System.out.println("Spot selected successfully!");
                selectedSpot = Map.of(rowNumber, seat);
            }

        } while (!isValidSpot);

        return selectedSpot;
    }

    private boolean isValidRange(int value) {
        return value >= 1 && value <= 10;
    }
    private boolean isSpotValid(int seat, int rowNumber, Map<Integer, List<Integer>> takenSpots) {
        if (takenSpots.containsKey(rowNumber) && takenSpots.get(rowNumber).contains(seat)) {
            System.out.println("Selected spot is already taken.");
            return false;
        }

        return true;
    }


}
