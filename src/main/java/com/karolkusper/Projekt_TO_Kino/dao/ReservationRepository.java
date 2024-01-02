package com.karolkusper.Projekt_TO_Kino.dao;


import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
