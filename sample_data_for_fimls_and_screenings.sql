-- Wstaw kilka przykładowych filmów
INSERT INTO films (film_id, title, director, release_year, rating)
VALUES
    (1, 'Inception', 'Christopher Nolan', 2010, 8.8),
    (2, 'The Shawshank Redemption', 'Frank Darabont', 1994, 9.3),
    (3, 'The Dark Knight', 'Christopher Nolan', 2008, 9.0),
    (4, 'Pulp Fiction', 'Quentin Tarantino', 1994, 8.9);

-- Wstaw kilka przykładowych seansów
INSERT INTO screenings (screening_id, film_id, date_and_time, hall, availability)
VALUES
    (1, 1, '2024-01-02 18:00:00', 'Hall A', TRUE),
    (2, 2, '2024-01-03 20:00:00', 'Hall B', TRUE),
    (3, 3, '2024-01-04 15:30:00', 'Hall C', FALSE),
    (4, 4, '2024-01-05 19:45:00', 'Hall A', TRUE);