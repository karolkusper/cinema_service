package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;
import com.karolkusper.Projekt_TO_Kino.command.AddFilmCommand;

import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.Scanner;


public class AddFilmHandler extends BaseHandler{
    private final CinemaService cinemaService;

    public AddFilmHandler(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void handleRequest() {
        String title;
        String director;
        int releaseYear;
        float rating;

        Scanner scanner = new Scanner(System.in);
        System.out.println("To add new movie to database fill in those information");
        System.out.println("Title: ");
        title=scanner.nextLine();
        System.out.println("Director: ");
        director=scanner.nextLine();
        System.out.println("Release Year: ");
        releaseYear=Integer.parseInt(scanner.nextLine());
        System.out.println("Rating: ");
        rating=Float.parseFloat(scanner.nextLine());

        new AddFilmCommand(cinemaService,title,director,releaseYear,rating).execute();

        System.out.println("Movie added to database.");

    }
}
