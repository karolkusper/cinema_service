package com.karolkusper.Projekt_TO_Kino;

import com.karolkusper.Projekt_TO_Kino.console.ConsoleMenu;
import com.karolkusper.Projekt_TO_Kino.service.CinemaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjektToKinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektToKinoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CinemaService cinemaService) {
		return runner -> {
			ConsoleMenu consoleMenu = new ConsoleMenu(cinemaService);
			consoleMenu.start();
		};
	}


}
