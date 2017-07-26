package ru.handbook;

import ru.handbook.view.ViewStarter;

import static ru.handbook.model.utilites.serialization.standart.StandartSerializer.serialize;

public class Main {

    public static void main(String[] args) {
        new ViewStarter();
        serialize();
    }
}