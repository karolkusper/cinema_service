package com.karolkusper.Projekt_TO_Kino.dao;


import com.karolkusper.Projekt_TO_Kino.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer> {
}
