package com.karolkusper.Projekt_TO_Kino.service;

import com.karolkusper.Projekt_TO_Kino.console.AdminMenu;
import com.karolkusper.Projekt_TO_Kino.console.ClientMenu;
import com.karolkusper.Projekt_TO_Kino.dao.ClientRepository;
import com.karolkusper.Projekt_TO_Kino.dao.FilmRepository;
import com.karolkusper.Projekt_TO_Kino.dao.ScreeningRepository;
import com.karolkusper.Projekt_TO_Kino.entity.Film;
import com.karolkusper.Projekt_TO_Kino.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CinemaService {
    private final FilmRepository filmRepository;
    private final ScreeningRepository screeningRepository;
    private final ClientRepository clientRepository;


    private final String password="haslo";

    @Autowired
    public CinemaService(FilmRepository filmRepository, ClientRepository clientRepository,ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.clientRepository = clientRepository;
        this.screeningRepository=screeningRepository;
    }

    // Implementacja logiki biznesowej z wykorzystaniem repozytoriów
    public void showAvailableMovies() {
        List<Film> allFilms = filmRepository.findAll();
        allFilms.forEach(System.out::println);
    }

    public void showAdminMenu() {
        AdminMenu.showAdminMenu();
    }

    public void showClientMenu() {
        ClientMenu.showClientMenu();
    }

    public void addScreening(int filmId, Date dateAndTime, String hall) {
        screeningRepository.saveAndFlush(new Screening(filmId,dateAndTime,hall));

    }

    public void addFilm(String title, String director, int releaseYear,float rating) {
        filmRepository.saveAndFlush(new Film(title, director, releaseYear, rating));
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