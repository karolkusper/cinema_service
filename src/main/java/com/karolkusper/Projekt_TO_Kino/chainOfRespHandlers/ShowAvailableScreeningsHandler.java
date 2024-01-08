package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

import com.karolkusper.Projekt_TO_Kino.command.ShowAvailableMoviesCommand;
import com.karolkusper.Projekt_TO_Kino.command.ShowAvailableScreeningsCommand;
import com.karolkusper.Projekt_TO_Kino.command.ShowFilmDetailsCommand;
import com.karolkusper.Projekt_TO_Kino.entity.Screening;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;

import java.util.List;

public class ShowAvailableScreeningsHandler extends BaseHandler{
    private final CinemaService cinemaService;
    public ShowAvailableScreeningsHandler(CinemaService cinemaService) {
        this.cinemaService=cinemaService;
    }
    @Override
    public void handleRequest() {

        System.out.println("These are currently screenings: ");
        //new ShowAvailableScreeningsCommand(cinemaService).execute();

        List<Screening> availableScreenings = cinemaService.getAvailableScreenings();
           for(Screening screening:availableScreenings){
               System.out.println();
               System.out.println("Screening id="+screening.getScreeningId());
               System.out.println("Movie: ");
               new ShowFilmDetailsCommand(cinemaService, screening.getFilmId()).execute();
               System.out.println("Date and time: "+screening.getDate());
               System.out.println("Hall: "+screening.getHall());
               System.out.println();
           }

        super.handleRequest();

    }
}
