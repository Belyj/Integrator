package ru.handbook.view;

import ru.handbook.controller.MenuControllerDAOImpl;

import java.util.Scanner;

public class Menu {

    MenuControllerDAOImpl controller = new MenuControllerDAOImpl();
    boolean flag = true;

    public Menu() {
        while (flag) {
            menuList();
            menuComand(keepComand());
        }
    }

    private void menuList() {
        System.out.println("Введите команду");
        System.out.println("1: Создать контакт\n" +
                            "2: Создать группу\n" +
                            "3: Удалить контакт\n" +
                            "4: Удалить группу\n" +
                            "5: Выход");
    }

    private int keepComand() {
        Scanner scanner = new Scanner(System.in);
        int comand = Integer.parseInt(scanner.next());
        return comand;
    }

    private void menuComand(int comand) {
        switch (comand) {
            case 1:
                controller.createContact();
                break;
            case 2:
                controller.createGroup();
                break;
            case 3:
                controller.deleteContact();
                break;
            case 4:
                controller.deleteGroup();
                break;
            case 5:
                flag = false;
                break;
            default:
                System.out.println("Данный вид команды не поддерживается");
        }
    }
}
