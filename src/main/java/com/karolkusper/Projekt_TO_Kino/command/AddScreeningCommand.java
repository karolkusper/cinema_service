package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Date;

public class AddScreeningCommand implements Command{
    CinemaService cinemaService;
    int filmId;
    Date dateAndTime;
    String hall;

    public AddScreeningCommand(CinemaService cinemaService, int filmId, Date dateAndTime, String hall) {
        this.cinemaService = cinemaService;
        this.filmId = filmId;
        this.dateAndTime = dateAndTime;
        this.hall = hall;
    }

    @Override
    public void execute() {
        cinemaService.addScreening(filmId,dateAndTime,hall);
    }
}
