package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class AdminHandler extends BaseHandler{

    private final CinemaService cinemaService;

    public AdminHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

            //przeniesc to do osobnej metody walidacyjnej
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter admin password: ");
            String enteredPassword = scanner.nextLine();

            if (cinemaService.checkAdminPassword(enteredPassword)) {
                int adminChoice;

                do {
                    cinemaService.showAdminMenu();
                    adminChoice = scanner.nextInt();

                    switch (adminChoice) {
                        case 1:
                            ShowAvailableMoviesHandler showAvailableMoviesHandler = new ShowAvailableMoviesHandler(cinemaService);
                            showAvailableMoviesHandler.setNextHandler(new AddScreeningHandler(cinemaService));
                            setNextHandler(showAvailableMoviesHandler);
                            break;
                        case 2:
                            setNextHandler(new AddFilmHandler(cinemaService));
                            break;
                        case 3:
                            setNextHandler(new DisplayReservationHandler(cinemaService));
                            break;
                        case 4:
                            DisplayReservationHandler displayReservationHandler = new DisplayReservationHandler(cinemaService);
                            displayReservationHandler.setNextHandler(new CancelReservationHandler(cinemaService));
                            setNextHandler(displayReservationHandler);
                            break;
                        case 5:
                            System.out.println("Exiting admin menu.");
                            setNextHandler(null);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            setNextHandler(null);
                            break;
                    }

                    super.handleRequest();

                } while (adminChoice != 5);
            } else {
                System.out.println("Incorrect admin password.");
            }

    }
}
