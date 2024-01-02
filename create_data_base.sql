-- Utwórz bazę danych
CREATE DATABASE IF NOT EXISTS cinema_db;
USE cinema_db;

-- Tabela Filmów
CREATE TABLE films (
    film_id INT PRIMARY KEY,
    title VARCHAR(255),
    director VARCHAR(255),
    release_year INT,
    rating DECIMAL(3,1)
);

-- Tabela Seansów
CREATE TABLE screenings (
    screening_id INT PRIMARY KEY,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES films(film_id),
    date_and_time DATETIME,
    hall VARCHAR(50),
    availability BOOLEAN
);

-- Tabela Rezerwacji
CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY,
    screening_id INT,
    FOREIGN KEY (screening_id) REFERENCES screenings(screening_id),
    seat INT,
    client_name VARCHAR(255),
    client_email VARCHAR(255)
);

-- Tabela Klientów
CREATE TABLE clients (
    client_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(255)
);