package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.ShowAvailableScreeningsCommand;
import com.karolkusper.Projekt_TO_Kino.command.ShowFilmDetailsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;

public class ShowFilmDetailsHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public ShowFilmDetailsHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter film id: ");
        int id = scanner.nextInt();
        new ShowFilmDetailsCommand(cinemaService,id).execute();

    }
}
