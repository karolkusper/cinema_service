package com.karolkusper.Projekt_TO_Kino.entity;

import jakarta.persistence.*;

@Entity
@Table(name="reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name="reservation_id")
    int reservationId;
    @Column(name="screening_id")
    int screeningId;

    @Column(name="seat")
    int seat;

    @Column(name="client_name")
    String clientName;
    @Column(name="client_email")
    String clientEmail;

    public Reservation(){

    }
    public Reservation(int screeningId, int seat, String clientName, String clientEmail) {
        this.screeningId = screeningId;
        this.seat = seat;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", screeningId=" + screeningId +
                ", seat=" + seat +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
