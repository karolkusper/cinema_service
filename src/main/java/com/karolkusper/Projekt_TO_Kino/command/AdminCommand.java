package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class AdminCommand implements Command{

    private final CinemaService cinemaService; //receiver

    public AdminCommand(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }
    @Override
    public void execute() {
        cinemaService.showAdminMenu();
    }
}
