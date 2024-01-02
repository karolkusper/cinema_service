package com.karolkusper.Projekt_TO_Kino.cosole;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class ConsoleMenu {
    private CinemaService cinemaService;

    public ConsoleMenu(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cinemaService.showAvailableScreenings();
                    break;
                case 2:
                 //   cinemaService.showFilmDetails();
                    break;
                case 3:
                    //cinemaService.makeReservation();
                    break;
                case 4:
                    //cinemaService.cancelReservation();
                    break;
                case 5:
                    //cinemaService.addScreening();
                    break;
                case 6:
                    //cinemaService.addFilm();
                    break;
                case 7:
                    //cinemaService.cancelReservationByAdmin();
                    break;
                case 8:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);
    }

    private void displayMenu() {
        System.out.println("1. Show available screenings");
        System.out.println("2. Show film details");
        System.out.println("3. Make a reservation");
        System.out.println("4. Cancel reservation");
        System.out.println("5. Add a screening");
        System.out.println("6. Add a film");
        System.out.println("7. Cancel reservation (admin)");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}
