package com.karolkusper.Projekt_TO_Kino;

import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.AdminHandler;
import com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers.ClientHandler;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ProjektToKinoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektToKinoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CinemaService cinemaService) {
        return runner -> {
            AdminHandler adminHandler = new AdminHandler(cinemaService);
            ClientHandler clientHandler = new ClientHandler(cinemaService);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("1. Enter as an admin");
                System.out.println("2. Enter as cinema customer");
                System.out.println("3. Exit");
                System.out.println();

                choice = scanner.nextInt();

                switch (choice) {
                    case (1) -> {
                        adminHandler.handleRequest();
                    }
                    case (2) -> {
                        clientHandler.handleRequest();
                    }
                    case (3) -> {
                        System.out.println("Ending the program ...");

                    }
                    default -> {
                        System.out.println("Not a valid choice!");
                    }
                }


            } while (choice != 3);

            System.out.println("The program ended.");
        };
    }
}

