package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.AddFilmHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.AddScreeningHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.DisplayReservationHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.CancelReservationHandler;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class AdminCommand implements Command {

    private final CinemaService cinemaService; // receiver

    public AdminCommand(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int adminChoice;

        do {
            cinemaService.showAdminMenu();
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    new AddScreeningHandler(cinemaService).handleRequest();
                    break;
                case 2:
                    new AddFilmHandler(cinemaService).handleRequest();
                    break;
                case 3:
                    new DisplayReservationHandler(cinemaService).handleRequest();
                    break;
                case 4:
                    new CancelReservationHandler(cinemaService).handleRequest();
                    break;
                case 5:
                    System.out.println("Exiting admin menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (adminChoice != 5);
    }
}
