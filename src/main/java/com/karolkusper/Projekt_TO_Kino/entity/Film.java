package com.karolkusper.Projekt_TO_Kino.entity;

import jakarta.persistence.*;

@Entity
@Table(name="films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name="film_id")
    int filmId;
    @Column(name="title")
    String Title;
    @Column(name="director")
    String Director;
    @Column(name="release_year")
    int releaseYear;
    @Column(name="rating")
    float rating;


    public Film()
    {

    }

    public Film(String title, String director, int releaseYear, float rating) {
        Title = title;
        Director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", Title='" + Title + '\'' +
                ", Director='" + Director + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
