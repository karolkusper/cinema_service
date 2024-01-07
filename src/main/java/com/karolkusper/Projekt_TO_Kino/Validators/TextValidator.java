package com.karolkusper.Projekt_TO_Kino.Validators;

import java.util.Scanner;

public class TextValidator implements Validator<String> {


    private static TextValidator instance;

    private TextValidator() {
        // Prywatny konstruktor
    }

    public static synchronized TextValidator getInstance() {
        if (instance == null) {
            instance = new TextValidator();
        }
        return instance;
    }

    @Override
    public String validate(Scanner scanner) {
        return scanner.nextLine().trim();
    }
}