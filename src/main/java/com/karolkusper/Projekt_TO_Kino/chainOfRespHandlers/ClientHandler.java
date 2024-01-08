package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class ClientHandler extends BaseHandler {
    private final CinemaService cinemaService;

    public ClientHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {
        Scanner scanner = new Scanner(System.in);
        int clientChoice;

        do {
            cinemaService.showClientMenu();
            clientChoice = scanner.nextInt();

            switch (clientChoice) {
                case 1:
                    setNextHandler(new ShowAvailableScreeningsHandler(cinemaService));
                    break;
                case 2:
                    ShowAvailableScreeningsHandler showAvailableScreeningsHandler1 = new ShowAvailableScreeningsHandler(cinemaService);
                    showAvailableScreeningsHandler1.setNextHandler(new ShowFilmDetailsHandler(cinemaService));
                    setNextHandler(showAvailableScreeningsHandler1);
                    break;
                case 3:
                    ShowAvailableScreeningsHandler showAvailableScreeningsHandler = new ShowAvailableScreeningsHandler(cinemaService);
                    showAvailableScreeningsHandler.setNextHandler(new AddReservationHandler(cinemaService));
                    setNextHandler(showAvailableScreeningsHandler);
                    //setNextHandler(new MakeReservationHandler(cinemaService));
                    break;
                case 4:
                    setNextHandler(new CancelReservationHandler(cinemaService));
                    break;
                case 5:
                    System.out.println("Exiting client menu.");
                    setNextHandler(null);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    setNextHandler(null);
                    break;
            }

            super.handleRequest();

        } while (clientChoice != 5);
    }
}
