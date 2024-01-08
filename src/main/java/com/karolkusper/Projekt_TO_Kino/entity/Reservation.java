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

    @Column(name="number_row")
    int rowNumber;

    @Column(name="client_name")
    String clientName;
    @Column(name="client_email")
    String clientEmail;

//    @Column(name="client_id")
//    int clientId;

    public Reservation(){

    }
    public Reservation(int screeningId, int seat,int rowNumber, String clientName, String clientEmail) {
        this.screeningId = screeningId;
        this.seat = seat;
        this.rowNumber=rowNumber;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
//        this.clientId=clientId;
    }

    public int getReservationId() {
        return reservationId;
    }


    public int getScreeningId() {
        return screeningId;
    }


    public int getSeat() {
        return seat;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getClientName() {
        return clientName;
    }


    public String getClientEmail() {
        return clientEmail;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", screeningId=" + screeningId +
                ", seat=" + seat +
                ", row=" + rowNumber +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
