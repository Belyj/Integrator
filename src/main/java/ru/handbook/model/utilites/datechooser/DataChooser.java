package ru.handbook.model.utilites.datechooser;

import ru.handbook.model.storage.DataStorage;
import ru.handbook.model.utilites.serialization.dom.DOMDeserializer;
import ru.handbook.model.utilites.serialization.dom.DOMSerializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonDeserializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonSerializer;
import ru.handbook.model.utilites.serialization.sax.SAXDeserializer;

import java.util.Observer;
import java.util.Scanner;

public class DataChooser {

    Scanner scanner = new Scanner(System.in);

    public DataChooser() {
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
        int command;
        if (scanner.hasNextInt()) {
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    new DOMDeserializer();
                    DataStorage.getInstance().addObserver(new DOMSerializer());
                    break;
                case 2:
                    new SAXDeserializer();
                    //DataStorage.getInstance().addObserver(new DOMSerializer());
                    break;
                case 3:
                    new JacksonDeserializer();
                    //DataStorage.getInstance().addObserver(new DOMSerializer());
                    DataStorage.getInstance().addObserver(new JacksonSerializer());

                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }
}
