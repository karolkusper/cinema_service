package com.karolkusper.Projekt_TO_Kino.Validators;

import com.karolkusper.Projekt_TO_Kino.Validators.Validator;

import java.util.Scanner;

public class IntegerValidator implements Validator<Integer> {

    private static IntegerValidator instance;

    private IntegerValidator() {
        // Prywatny konstruktor
    }

    public static synchronized IntegerValidator getInstance() {
        if (instance == null) {
            instance = new IntegerValidator();
        }
        return instance;
    }

    @Override
    public Integer validate(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
            }
        }
    }
}
