package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ClientCommand implements Command{
    private final CinemaService cinemaService; //receiver
    public ClientCommand(CinemaService cinemaService)
    {
        this.cinemaService=cinemaService;
    }

    @Override
    public void execute() {
        cinemaService.showClientMenu();
    }
}
