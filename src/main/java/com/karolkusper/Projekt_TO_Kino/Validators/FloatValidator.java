package com.karolkusper.Projekt_TO_Kino.Validators;

import com.karolkusper.Projekt_TO_Kino.Validators.Validator;

import java.util.Scanner;

public class FloatValidator implements Validator<Float> {

    private static FloatValidator instance;

    private FloatValidator() {
        // Prywatny konstruktor
    }

    public static synchronized FloatValidator getInstance() {
        if (instance == null) {
            instance = new FloatValidator();
        }
        return instance;
    }

    @Override
    public Float validate(Scanner scanner) {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid float:");
            }
        }
    }
}
