package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;
import com.karolkusper.Projekt_TO_Kino.Validators.FloatValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.Validators.TextValidator;
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
        TextValidator textValidator = TextValidator.getInstance();
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        FloatValidator floatValidator = FloatValidator.getInstance();

        System.out.println("To add new movie to database fill in those information");
        System.out.println("Title: ");
        title= textValidator.validate(scanner);
        System.out.println("Director: ");
        director=textValidator.validate(scanner);
        System.out.println("Release Year: ");
        releaseYear= integerValidator.validate(scanner);
        System.out.println("Rating: ");
        rating= floatValidator.validate(scanner);

        new AddFilmCommand(cinemaService,title,director,releaseYear,rating).execute();

        System.out.println("Movie added to database.");

    }
}
