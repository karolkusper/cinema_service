package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ShowAvailableScreeningsCommand implements Command{
    private CinemaService cinemaService;
    public ShowAvailableScreeningsCommand(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.showAvailableScreenings();
    }
}
