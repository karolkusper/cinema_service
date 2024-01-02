package com.karolkusper.Projekt_TO_Kino;

import com.karolkusper.Projekt_TO_Kino.dao.ClientRepository;
import com.karolkusper.Projekt_TO_Kino.dao.FilmRepository;
import com.karolkusper.Projekt_TO_Kino.entity.Film;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;
import java.util.List;

@SpringBootApplication
public class ProjektToKinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektToKinoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ClientRepository clientRepository,FilmRepository filmRepository) {
		return runner -> {
			showFilms(filmRepository);
		};
	}

	public void showFilms(FilmRepository filmRepository)
	{
		List<Film> allFilms = filmRepository.findAll();
		allFilms.forEach(System.out::println);

	}
}
