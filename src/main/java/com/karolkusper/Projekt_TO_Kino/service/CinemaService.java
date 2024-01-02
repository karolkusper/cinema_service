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

}