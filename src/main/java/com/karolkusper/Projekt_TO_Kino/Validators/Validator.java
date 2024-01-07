package com.karolkusper.Projekt_TO_Kino.Validators;

import java.util.Scanner;

public interface Validator<T> {
    T validate(Scanner scanner);
}