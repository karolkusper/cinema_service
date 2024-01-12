package com.karolkusper.Projekt_TO_Kino.Validators.Decorators;

import com.karolkusper.Projekt_TO_Kino.Validators.Validator;

import java.util.Scanner;

public class BaseDecorator<T> implements Validator<T>{
    Validator<T> validator;
    public BaseDecorator()
    {}

    public BaseDecorator(Validator<T> validator) {
        this.validator = validator;
    }

    @Override
    public T validate(Scanner scanner) {
        return validator.validate(scanner);
    }

}
