package com.karolkusper.Projekt_TO_Kino.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name="screening_id")
    int screeningId;

    @Column(name="film_id")
    int filmId;

    @Column(name="date_and_time")
    Date date;

    @Column(name="hall")
    String hall;


    public Screening()
    {

    }

    public Screening(int filmId, Date date, String hall) {
        this.filmId = filmId;
        this.date = date;
        this.hall = hall;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId=" + screeningId +
                ", filmId=" + filmId +
                ", date=" + date +
                ", hall='" + hall + '\'' +
                '}';
    }
}
