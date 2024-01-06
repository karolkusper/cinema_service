package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

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
                    new ShowAvailableScreeningsCommand(cinemaService).execute();
                    break;
                case 2:
                    System.out.println("Enter film id: ");
                    int id = scanner.nextInt();
                    new ShowFilmDetailsCommand(cinemaService,id).execute();
                    break;
                case 3:
                    new MakeReservationCommand(cinemaService).execute();
                    break;
                case 4:
                    System.out.println("Enter reservation id: ");
                    int idRes = scanner.nextInt();
                    new CancelReservationCommand(cinemaService,idRes).execute();
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
