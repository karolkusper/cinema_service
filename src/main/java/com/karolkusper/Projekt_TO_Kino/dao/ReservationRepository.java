package com.karolkusper.Projekt_TO_Kino.dao;


import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    @Query("SELECT r FROM Reservation r WHERE r.screeningId = :screeningId")
    List<Reservation> findByScreeningId(@Param("screeningId") int screeningId);
}
