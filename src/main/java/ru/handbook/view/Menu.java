package ru.handbook.view;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.view.contactview.ContactView;
import ru.handbook.view.contactview.Observer;

import java.util.List;
import java.util.Scanner;

public class Menu implements Observer {

    MenuController controller = new MenuController();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    ContactView contactView = new ContactView();

    public Menu() {
        while (flag) {
            menuList();
            menuCommand(keepCommand());
        }
    }

    private void menuList() {
        System.out.println("Введите команду");
        System.out.println("0: Создать контакт\n" +
                "1: Создать группу\n" +
                "2: Найти контакт\n" +
                "3: Найти группу\n" +
                "4: Удалить контакт\n" +
                "5: Удалить группу\n" +
                "6: Обновить контакт\n" +
                "7: Обновить группу\n" +
                "8: Добавить в группу\n" +
                "9: Удалить из группы\n" +
                "10: просмотреть все контакты\n" +
                "11: просмотреть все группы\n" +
                "12: Выход");
    }

    private int keepCommand() {
        int command;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            command = scanner.nextInt();
        } else command = -1;
        return command;
    }

    private void menuCommand(int command) {
        Contact contact;
        Group group;
        List<Contact> contacts;
        List<Integer> contactsId;
        switch (command) {
            case 0:
                contact = controller.createContact(initializeConract());
                System.out.println(contact.getName() + " создан");
                break;
            case 1:
                group = controller.createGroup(initializeGroup());
                System.out.println(group.getName() + " создана");
                break;
            case 2:
                contact = controller.searchContact(initializeConract());
                if (contact != null) {
                    System.out.println("id: " + contact.getId() + ";" + "\t" +
                            "name: " + contact.getName() + ";" + "\t" +
                            "phone: " + contact.getPhone() + ";" + "\t" +
                            "skype: " + contact.getSkype() + ";" + "\t" +
                            "mail: " + contact.getMail() + ";");
                } else System.out.println("Контакт не существует");
                break;
            case 3:
                group = controller.searchGroup(initializeGroup());
                if (group != null) {
                    System.out.println(group.getName() + " " + group.getId());
                    for (Contact innerContact : group.getInner()) {
                        System.out.println(innerContact);
                    }
                } else System.out.println("Группа не существует");
                break;
            case 4:
                contact = controller.deleteContact(initializeConract());
                System.out.println(contact.getName() + " удален");
                break;
            case 5:
                group = controller.deleteGroup(initializeGroup());
                System.out.println(group.getName() + " удалена");
                break;
            case 6:
                contact = controller.updateContact(initializeConract());
                System.out.println(contact.getName() + " обновлен");
                break;
            case 7:
                group = controller.updateGroup(initializeGroup());
                System.out.println(group.getName() + " обновлена");
                break;
            case 8:
                contact = controller.searchContact(initializeConract());
                group = controller.searchGroup(initializeGroup());
                contacts = group.getInner();
                contacts.add(contact);
                group.setInner(contacts);
                controller.addInGroup(contact, group);
                System.out.println(contact.getName() + " добавлен в группу " + group.getName());
                break;
            case 9:
                contact = controller.searchContact(initializeConract());
                group = controller.searchGroup(initializeGroup());
                controller.deleteFromGroup(contact, group);
                contacts = group.getInner();
                contacts.remove(contact);
                group.setInner(contacts);
                System.out.println(contact.getName() + " удален из группы " + group.getName());
                break;
            case 10:
                contacts = controller.checkContacts();
                for (Contact gettingContact : contacts) {
                    System.out.println("id: " + gettingContact.getId() + ";" + "\t" +
                            "name: " + gettingContact.getName() + ";" + "\t" +
                            "phone: " + gettingContact.getPhone() + ";" + "\t" +
                            "skype: " + gettingContact.getSkype() + ";" + "\t" +
                            "mail: " + gettingContact.getMail() + ";");
                }
                break;
            case 11:
                List<Group> groups = controller.checkGroups();
                for (Group gettingGroup : groups) {
                    System.out.println("Group id: " + gettingGroup.getId() + " " + "group name: " + gettingGroup.getName());
                }
                break;
            case 12:
                System.out.println("Exit");
                contactView.dispose();
                flag = false;
                break;
            default:
                System.out.println("Данный вид команды не поддерживается");
        }
    }

    Contact initializeConract() {
        Contact contact = new Contact();
        System.out.println("Введите имя контакта");
        contact.setName(scanner.nextLine());
        System.out.println("Введите ID контакта");
        if (scanner.hasNextInt()) {
            contact.setId(scanner.nextInt());
        }
        return contact;
    }

    Group initializeGroup() {
        Group group = new Group();
        System.out.println("Введите имя группы");
        group.setName(scanner.nextLine());
        System.out.println("Введите ID группы");
        if (scanner.hasNextInt()) {
            group.setId(scanner.nextInt());
        }
        return group;
    }

    @Override
    public void handleEvent() {
        menuCommand(10);
        menuCommand(11);
    }
}
