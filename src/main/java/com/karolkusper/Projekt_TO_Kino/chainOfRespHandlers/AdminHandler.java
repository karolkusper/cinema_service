package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.AdminCommand;
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
                new AdminCommand(cinemaService).execute();
            } else {
                System.out.println("Incorrect admin password.");
            }

    }
}
