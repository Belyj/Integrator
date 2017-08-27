package ru.handbook.model.utilites.datechooser;

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
                    //new ContactServiceImpl().setDOM();
                    break;
                case 2:
                    //new ContactServiceImpl().setSAX();
                    break;
                case 3:
                    System.out.println("Пока не поддерживается");
                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }
}
