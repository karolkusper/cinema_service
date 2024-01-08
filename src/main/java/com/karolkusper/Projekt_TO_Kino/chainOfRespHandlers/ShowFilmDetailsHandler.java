package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.Validators.IntegerValidator;
import com.karolkusper.Projekt_TO_Kino.command.ShowFilmDetailsCommand;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import org.springframework.data.relational.core.sql.In;

import java.util.Scanner;

public class ShowFilmDetailsHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public ShowFilmDetailsHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {
        Scanner scanner = new Scanner(System.in);
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        System.out.println("Enter film id: ");
        int id = integerValidator.validate(scanner);
        new ShowFilmDetailsCommand(cinemaService,id).execute();

        super.handleRequest();

    }
}
