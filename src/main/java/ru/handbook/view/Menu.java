package ru.handbook.view;

import ru.handbook.controller.MenuController;

import java.util.Scanner;

public class Menu {

    MenuController controller = new MenuController();
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
                            "3: Найти контакт\n" +
                            "4: Найти группу\n" +
                            "5: Удалить контакт\n" +
                            "6: Удалить группу\n" +
                            "7: Обновить контакт\n" +
                            "8: Обновить группу\n" +
                            "9: просмотреть все контакты\n" +
                            "10: просмотреть все группы\n" +
                            "11: Выход");
    }

    private int keepComand() {
        int comand;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            comand = Integer.parseInt(scanner.nextLine());
        } else comand = 0;
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
                controller.searchContact();
                break;
            case 4:
                controller.searchGroup();
                break;
            case 5:
                controller.deleteContact();
                break;
            case 6:
                controller.deleteGroup();
                break;
            case 7:
                controller.updateContact();
                break;
            case 8:
                controller.deleteGroup();
                break;
            case 9:
                controller.checkContacts();
                break;
            case 10:
                controller.checkGroups();
                break;
            case 11:
                flag = false;
                break;
            default:
                System.out.println("Данный вид команды не поддерживается");
        }
    }
}
