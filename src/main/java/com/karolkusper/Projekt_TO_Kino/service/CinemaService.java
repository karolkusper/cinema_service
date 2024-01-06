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
        System.out.println("1. Continue as Admin");
        System.out.println("2. Continue as Client");
        System.out.println("3. Exit");
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
}