package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class AdminCommand implements Command{

    private final CinemaService cinemaService; //receiver

    public AdminCommand(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int adminChoice;

        do{
            cinemaService.showAdminMenu();
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    new AddScreeningCommand(cinemaService).execute();
                    break;
                case 2:
                    new AddFilmCommand(cinemaService).execute();
                    break;
                case 3:
                    new DisplayReservationsCommand(cinemaService).execute();
                    break;
                case 4:
                    System.out.println("Enter reservation id: ");
                    int id = scanner.nextInt();
                    new CancelReservationsCommand(cinemaService,id).execute();
                    break;
                case 5:
                    System.out.println("Exiting admin menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while (adminChoice!=5);

    }
}
