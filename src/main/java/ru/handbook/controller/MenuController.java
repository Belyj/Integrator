package ru.handbook.controller;

import ru.handbook.model.dao.ContactDAOImpl;
import ru.handbook.model.dao.GroupDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.util.Scanner;

public class MenuController implements ContactController, GroupController {

    ContactDAOImpl contactDAO = new ContactDAOImpl();
    GroupDAOImpl groupDAO = new GroupDAOImpl();
    DataStorage source = DataStorage.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void createContact() {
        contactDAO.create();
    }

    public void deleteContact() {
        System.out.println("Введите имя");
        contactDAO.delete(source.getContactByName(scanner.next()));
    }

    public void searchContact() {
        System.out.println("Введите имя");
        contactDAO.search(source.getContactByName(scanner.next()));
    }

    public void searchGroup() {
        System.out.println("Введите имя");
        groupDAO.search(source.getGroupByName(scanner.next()));
    }

    public void createGroup() {
        groupDAO.create();
    }

    public void deleteGroup() {
        System.out.println("Введите имя");
        groupDAO.delete(source.getGroupByName(scanner.next()));
    }

    public void updateContact() {
        System.out.println("Введите имя");
        Contact searchable =
        contactDAO.update();
    }

    public void updateGroup() {
        //TODO: обновить группу через ДАО
    }

    public void checkContacts() {
        //TODO: просмотреть контакты через storage
    }

    public void checkGroups() {
        //TODO: просмотреть группы через storage
    }
}
