package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.ClientCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

public class ClientHandler extends BaseHandler
{
    private final CinemaService cinemaService;

    public ClientHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {

        new ClientCommand(cinemaService).execute();

    }
}
