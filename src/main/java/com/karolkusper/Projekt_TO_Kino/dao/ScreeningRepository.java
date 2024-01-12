package com.karolkusper.Projekt_TO_Kino.dao;


import com.karolkusper.Projekt_TO_Kino.entity.Reservation;
import com.karolkusper.Projekt_TO_Kino.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening,Integer> {

    @Query("SELECT s FROM Screening s WHERE s.hall = :hall")
    List<Screening> getScreeningsByHall(@Param("hall") String hall);

}
