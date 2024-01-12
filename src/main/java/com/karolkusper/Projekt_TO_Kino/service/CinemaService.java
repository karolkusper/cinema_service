package com.karolkusper.Projekt_TO_Kino.service;

import com.karolkusper.Projekt_TO_Kino.console.AdminMenu;
import com.karolkusper.Projekt_TO_Kino.console.ClientMenu;
import com.karolkusper.Projekt_TO_Kino.dao.FilmRepository;
import com.karolkusper.Projekt_TO_Kino.dao.ReservationRepository;
import com.karolkusper.Projekt_TO_Kino.dao.ScreeningRepository;
import com.karolkusper.Projekt_TO_Kino.entity.Film;
import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaService {
    private final FilmRepository filmRepository;
    private final ScreeningRepository screeningRepository;

    private final ReservationRepository reservationRepository;


    private final String password="haslo";

    @Autowired
    public CinemaService(FilmRepository filmRepository, ScreeningRepository screeningRepository, ReservationRepository reservationRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository=screeningRepository;
        this.reservationRepository=reservationRepository;
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

    public void addReservation(int screeningId, int seat, int rowNumber, String name, String email) {
        Reservation reservation = new Reservation(screeningId, seat, rowNumber, name, email);
        reservationRepository.saveAndFlush(reservation);
    }



    public void displayReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(System.out::println);
    }

    public Map<Integer, List<Integer>> getFreeSpots(int screeningId) {
        // Utwórz mapę reprezentującą wszystkie miejsca w kinie
        Map<Integer, List<Integer>> allSpots = new HashMap<>();
        int totalRows = 10;
        int seatsPerRow = 10;

        for (int row = 1; row <= totalRows; row++) {
            List<Integer> seatsInRow = new ArrayList<>();
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seatsInRow.add(seat);
            }
            allSpots.put(row, seatsInRow);
        }

        // Pobierz listę zajętych miejsc na podstawie rezerwacji
        List<Reservation> reservations = reservationRepository.findByScreeningId(screeningId);
        for (Reservation reservation : reservations) {
            // Usuń zajęte miejsce z mapy
            int rowNumber = reservation.getRowNumber();
            int seatNumber = reservation.getSeat();

            if (allSpots.containsKey(rowNumber)) {
                allSpots.get(rowNumber).remove(Integer.valueOf(seatNumber));
            }
        }

        // Zwróć mapę zawierającą wolne miejsca
        return allSpots;
    }

    public Map<Integer, List<Integer>> getTakenSpots(int screeningId) {
        // Pobierz listę zajętych miejsc na podstawie rezerwacji
        List<Reservation> reservations = reservationRepository.findByScreeningId(screeningId);

        // Utwórz mapę reprezentującą zajęte miejsca w kinie
        Map<Integer, List<Integer>> takenSpots = new HashMap<>();

        // Grupuj rezerwacje według numeru rzędu
        Map<Integer, List<Reservation>> groupedReservations = reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getRowNumber));

        // Mapuj zgrupowane rezerwacje na zajęte miejsca w danym rzędzie
        for (Map.Entry<Integer, List<Reservation>> entry : groupedReservations.entrySet()) {
            int rowNumber = entry.getKey();
            List<Integer> takenSeats = entry.getValue().stream()
                    .map(Reservation::getSeat)
                    .collect(Collectors.toList());
            takenSpots.put(rowNumber, takenSeats);
        }

        return takenSpots;
    }

    public void cancelReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public void showFilmDetails(int filmId) {
        Optional<Film> filmById = filmRepository.findById(filmId);
        if(filmById.isPresent())
        {
            System.out.println(filmById.get());
        }
        else{
            System.out.println("There is no such movie in our cinema!");
        }
    }


    public boolean checkAdminPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public void showAvailableScreenings() {
        List<Screening> allScreenigns = screeningRepository.findAll();
        allScreenigns.forEach(System.out::println);
    }
    public List<Screening> getAvailableScreenings() {
        return screeningRepository.findAll();
    }

    public boolean isScreeningExist(int screeningId)
    {
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        return screening.isPresent();
    }
}