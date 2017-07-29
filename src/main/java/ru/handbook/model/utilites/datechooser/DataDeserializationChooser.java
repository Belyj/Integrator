package ru.handbook.model.utilites.datechooser;

import ru.handbook.model.utilites.serialization.dom.DOMDeserializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonDeserializer;

import java.util.Scanner;

public class DataDeserializationChooser {

    public DataDeserializationChooser() {
        System.out.println("Выберите способ для десериализации данных");
        chooseMenu();
        choose();
    }

    private void chooseMenu() {
        System.out.println("1: С помощью DOM\n" +
                            "2: С помощью SAX\n" +
                            "3: С помощью Jackson\n" +
                            "4: Exit");
    }

    private void choose() {
        int command = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (command) {
            case 1:
                new DOMDeserializer();
                break;
            case 2:
                System.out.println("Данный вид десериализации в разработке");
                break;
            case 3:
                new JacksonDeserializer();
                break;
            default:
                System.out.println("Такой команды нет");
                break;
        }
    }
}
