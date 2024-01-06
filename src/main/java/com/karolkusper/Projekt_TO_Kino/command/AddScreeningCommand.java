package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class AddScreeningCommand implements Command{
    CinemaService cinemaService;
    public AddScreeningCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.addScreening();
    }
}
