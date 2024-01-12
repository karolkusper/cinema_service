package com.karolkusper.Projekt_TO_Kino.console;

import java.util.List;
import java.util.Map;

public class ClientMenu {
    public static void showClientMenu() {
        System.out.println();
        System.out.println("1. Show available screenings");
        System.out.println("2. Show all movies currently played at our cinema:");
        System.out.println("3. Make a reservation");
        System.out.println("4. Cancel reservation");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void displayFreeSpots(Map<Integer, List<Integer>> freeSpots) {
        System.out.println("Free Spots in this Screening:");

        for (Map.Entry<Integer, List<Integer>> entry : freeSpots.entrySet()) {
            int row = entry.getKey();
            List<Integer> seats = entry.getValue();

            System.out.print("Row " + row + ": ");
            if (seats.isEmpty()) {
                System.out.println("No free seats in this row");
            } else {
                System.out.println("Free seats: " + seats);
            }
        }
    }

}
