package com.karolkusper.Projekt_TO_Kino.service;

import com.karolkusper.Projekt_TO_Kino.console.AdminMenu;
import com.karolkusper.Projekt_TO_Kino.console.ClientMenu;
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
        AdminMenu.showAdminMenu();
    }

    public void showClientMenu() {
        ClientMenu.showClientMenu();
    }

    public void addScreening() {
        System.out.println("\nAdding sreening");
    }

    public void addFilm() {
        System.out.println("\nAdding new film");
    }

    public void displayReservations() {
        System.out.println("\nDisplaying reservations");
    }

    public void cancelReservation(int reservationId) {
        System.out.println("\nCanceling reservation od id="+reservationId);
    }

    public void showFilmDetails(int filmId) {
        System.out.println("\nShow details about film of id: "+filmId);
    }

    public void makeReservation() {
        System.out.println("\nMaking Reservation");
    }

    public boolean checkAdminPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }
}