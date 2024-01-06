package com.karolkusper.Projekt_TO_Kino.service;

import com.karolkusper.Projekt_TO_Kino.dao.ClientRepository;
import com.karolkusper.Projekt_TO_Kino.dao.FilmRepository;
import com.karolkusper.Projekt_TO_Kino.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private final FilmRepository filmRepository;
    private final ClientRepository clientRepository;

    private final String password="haslo";

    @Autowired
    public CinemaService(FilmRepository filmRepository, ClientRepository clientRepository) {
        this.filmRepository = filmRepository;
        this.clientRepository = clientRepository;
    }

    // Implementacja logiki biznesowej z wykorzystaniem repozytoriów
    public void showAvailableScreenings() {
        List<Film> allFilms = filmRepository.findAll();
        allFilms.forEach(System.out::println);
    }

    public void showAdminMenu() {
        System.out.println("1. Add a screening");
        System.out.println("2. Add a film");
        System.out.println("3. Display reservations");
        System.out.println("4. Cancel reservations");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void showClientMenu() {
        System.out.println("1. Show available screenings");
        System.out.println("2. Show film details");
        System.out.println("3. Make a reservation");
        System.out.println("4. Cancel reservation");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addScreening() {
        System.out.println("Adding sreening");
    }

    public void addFilm() {
        System.out.println("Adding new film");
    }

    public void displayReservations() {
        System.out.printf("Displaying reservations");
    }

    public void cancelReservation(int reservationId) {
        System.out.println("Canceling reservation od id="+reservationId);
    }

    public void showFilmDetails(int filmId) {
        System.out.println("Show details about film of id: "+filmId);
    }

    public void makeReservation() {
        System.out.println("Making Reservation");
    }

    public boolean checkAdminPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }
}