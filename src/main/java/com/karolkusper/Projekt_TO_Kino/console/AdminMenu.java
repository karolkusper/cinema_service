package com.karolkusper.Projekt_TO_Kino.console;

import com.karolkusper.Projekt_TO_Kino.entity.Reservation;

import java.util.List;

public class AdminMenu {
    public static void showAdminMenu() {
        System.out.println();
        System.out.println("1. Add a screening");
        System.out.println("2. Add a film");
        System.out.println("3. Display reservations");
        System.out.println("4. Cancel reservations");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void displayReservations(List<Reservation> reservations){
        if(reservations.isEmpty())
        {
            System.out.println("There is no reservations yet!");
        }
        else{
            System.out.println("Reservations in our cinema:");
            for(Reservation reservation:reservations)
            {
                System.out.println(reservation);
            }
        }
    }
}
