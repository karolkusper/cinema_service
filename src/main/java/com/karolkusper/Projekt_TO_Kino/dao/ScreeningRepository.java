package com.karolkusper.Projekt_TO_Kino.dao;


import com.karolkusper.Projekt_TO_Kino.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening,Integer> {
}
