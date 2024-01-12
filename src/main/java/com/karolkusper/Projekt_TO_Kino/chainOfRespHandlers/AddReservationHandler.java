package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.DateTimeValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.Decorators.ReservationValidationDecorator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
import com.karolkusper.Projekt_TO_Kino.command.AddReservationCommand;
import com.karolkusper.Projekt_TO_Kino.command.AddScreeningCommand;
import com.karolkusper.Projekt_TO_Kino.command.DisplayFreeSpotsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AddReservationHandler extends BaseHandler{
    private final CinemaService cinemaService;


    public AddReservationHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        int screeningId;
        Map.Entry<Integer, Integer> selectedSpot;
        int seat;
        int rowNumber;
        String name;
        String email;

        Scanner scanner = new Scanner(System.in);
        TextValidator textValidator = TextValidator.getInstance();
        IntegerValidator integerValidator = IntegerValidator.getInstance();


        ReservationValidationDecorator reservationValidator = new ReservationValidationDecorator(integerValidator, scanner, cinemaService);

        System.out.println("Fill in information about reservation:");
        // Wczytaj screeningId przy użyciu ReservationValidationDecorator
        System.out.println("Screening Id: ");
        screeningId = reservationValidator.validateScreeningId();

        if(isAllSpotsTaken(screeningId,cinemaService))
        {
            System.out.println("There is no free spots! Reservation not possible for this screening");
            return;
        }

        // Wczytaj seat i row przy użyciu ReservationValidationDecorator
        new DisplayFreeSpotsCommand(cinemaService.getFreeSpots(screeningId)).execute();

        selectedSpot = reservationValidator.validateSeatAndRow(screeningId).entrySet().iterator().next();
        seat = selectedSpot.getValue();// Pobierz wartość jako seat
        rowNumber= selectedSpot.getKey(); // Pobierz klucz jako row

        System.out.println("Your name:");
        name=textValidator.validate(scanner);
        System.out.println("Your email:");
        email=textValidator.validate(scanner);


        System.out.println("Your reservation data:");
        System.out.println("Screeningid: "+screeningId);
        System.out.println("seat: "+seat);
        System.out.println("row: "+rowNumber);
        System.out.println("name:"+name);
        System.out.println("email:"+email);


        // Przekazujesz selectedSpot jako seat (value) i row (key) do konstruktora
        new AddReservationCommand(
                cinemaService,
                screeningId,
                seat,
                rowNumber,
                name,
                email
        ).execute();

        super.handleRequest();

    }
    private boolean isAllSpotsTaken(int screeningId, CinemaService cinemaService) {
        Map<Integer, List<Integer>> freeSpots = cinemaService.getFreeSpots(screeningId);
        int freeSpotCounter = 0;

        for (List<Integer> seats : freeSpots.values()) {
            freeSpotCounter += seats.size();
        }

        return freeSpotCounter == 0; // Jeśli liczba wolnych miejsc wynosi 0, to wszystkie miejsca są zajęte
    }
}
