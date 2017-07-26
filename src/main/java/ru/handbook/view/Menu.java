package ru.handbook.view;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.util.List;
import java.util.Scanner;

public class Menu {

    MenuController controller = new MenuController();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        while (flag) {
            menuList();
            menuCommand(keepCommand());
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

    private int keepCommand() {
        int command;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            command = Integer.parseInt(scanner.nextLine());
        } else command = 0;
        return command;
    }

    private void menuCommand(int command) {
        Contact contact;
        Group group;
        switch (command) {
            case 1:
                contact = controller.createContact(initializeConract());
                System.out.println(contact.getName() + " создан");
                break;
            case 2:
                group = controller.createGroup(initializeGroup());
                System.out.println(group.getName() + " создана");
                break;
            case 3:
                 contact = controller.searchContact(initializeConract());
                System.out.println(contact.getName() + " " +  contact.getId());
                break;
            case 4:
                group = controller.searchGroup(initializeGroup());
                System.out.println(group.getName() + " " + group.getId());
                break;
            case 5:
                contact = controller.deleteContact(initializeConract());
                System.out.println(contact.getName() + " удален");
                break;
            case 6:
                group = controller.deleteGroup(initializeGroup());
                System.out.println(group.getName() + " удалена");
                break;
            case 7:
                contact = controller.updateContact(initializeConract());
                System.out.println(contact.getName() + " обновлен");
                break;
            case 8:
                group = controller.updateGroup(initializeGroup());
                System.out.println(group.getName() + " обновлена");
                break;
            case 9:
                List<Contact> contacts = controller.checkContacts();
                for (Contact gettingContact : contacts) {
                    System.out.println(gettingContact.getName() + " " + gettingContact.getId());
                }
                break;
            case 10:
                List<Group> groups = controller.checkGroups();
                for (Group gettingGroup : groups) {
                    System.out.println(gettingGroup.getName() + " " + gettingGroup.getId());
                }
                break;
            case 11:
                flag = false;
                break;
            default:
                System.out.println("Данный вид команды не поддерживается");
        }
    }

    Contact initializeConract() {
        Contact contact = new Contact();
        System.out.println("Введите имя");
        contact.setName(scanner.nextLine());
        return contact;
    }

    Group initializeGroup() {
        Group group = new Group();
        System.out.println("Введите имя");
        group.setName(scanner.nextLine());
        return group;
    }
}
