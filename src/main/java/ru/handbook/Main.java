package ru.handbook;

import ru.handbook.model.utilites.datechooser.DataDeserializationChooser;
import ru.handbook.model.utilites.datechooser.DataSerializationChooser;
import ru.handbook.view.ViewStarter;

public class Main {

    public static void main(String[] args) {
        new DataDeserializationChooser();
        new ViewStarter();
        new DataSerializationChooser();
    }
}