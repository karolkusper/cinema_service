package com.karolkusper.Projekt_TO_Kino.dao;

import com.karolkusper.Projekt_TO_Kino.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
