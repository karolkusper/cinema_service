package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.MakeReservationHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.ShowAvailableScreeningsHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.ShowFilmDetailsHandler;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.CancelReservationHandler;

import java.util.Scanner;

public class ClientCommand implements Command{
    private final CinemaService cinemaService; //receiver
    public ClientCommand(CinemaService cinemaService)
    {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int clientChoice;

        do {
            cinemaService.showClientMenu();
            clientChoice = scanner.nextInt();

            switch (clientChoice) {
                case 1:
                    new ShowAvailableScreeningsHandler(cinemaService).handleRequest();
                    break;
                case 2:

                    new ShowFilmDetailsHandler(cinemaService).handleRequest();
                    break;
                case 3:
                    new MakeReservationHandler(cinemaService).handleRequest();
                    break;
                case 4:
                    new CancelReservationHandler(cinemaService).handleRequest();
                    break;
                case 5:
                    System.out.println("Exiting client menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (clientChoice != 5);
    }
}
