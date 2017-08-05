package ru.handbook.view;

import ru.handbook.controller.MenuController;
import ru.handbook.dao.parsersdao.dom.DOMGroupDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;
import ru.handbook.model.utilites.datechooser.DataChooser;
import ru.handbook.view.contactview.ContactView;

import java.util.List;
import java.util.Scanner;

public class Menu {

    MenuController controller = new MenuController();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    ContactView contactView = new ContactView();

    public Menu() {
        while (flag) {
            new DataChooser();
            DataStorage.getInstance().notifyObservers();
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
                    System.out.println(contact.getName() + " "
                            +  contact.getId() + " "
                            + contact.getPhone() + " "
                            + contact.getSkype() + " "
                            + contact.getMail());
                } else System.out.println("Контакт не существует");
                break;
            case 3:
                group = controller.searchGroup(initializeGroup());
                if (group != null) {
                    System.out.println(group.getName() + " " + group.getId());
                    for (Integer innerContact : group.getInner()) {
                        System.out.println("Inner contact id: " + innerContact);
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
                contactsId = group.getInner();
                contactsId.add(contact.getId());
                group.setInner(contactsId);
                controller.addInGroup(contact, group);
                System.out.println(contact.getName() + " добавлен в группу " + group.getName());
                break;
            case 9:
                contact = controller.searchContact(initializeConract());
                group = controller.searchGroup(initializeGroup());
                controller.deleteFromGroup(contact, group);
                contactsId = group.getInner();
                contactsId.remove(contact);
                group.setInner(contactsId);
                System.out.println(contact.getName() + " удален из группы " + group.getName());
                break;
            case 10:
                contacts = controller.checkContacts();
                for (Contact gettingContact : contacts) {
                    System.out.println(gettingContact.getName() + " "
                            + gettingContact.getId() + " "
                            + gettingContact.getPhone() + " "
                            + gettingContact.getSkype() + " "
                            + gettingContact.getMail());
                }
                break;
            case 11:
                List<Group> groups = controller.checkGroups();
                for (Group gettingGroup : groups) {
                    System.out.println(gettingGroup.getName() + " " + gettingGroup.getId());
                    for (Integer innerContact : gettingGroup.getInner()) {
                        System.out.println("Inner contact id " + innerContact);
                    }
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
        return contact;
    }

    Group initializeGroup() {
        Group group = new Group();
        System.out.println("Введите имя группы");
        group.setName(scanner.nextLine());
        return group;
    }
}
