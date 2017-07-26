package ru.handbook.controller;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.ContactServiceImpl;
import ru.handbook.services.GroupServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuController implements ContactController, GroupController {

    ContactServiceImpl contactService = new ContactServiceImpl();
    GroupServiceImpl groupService = new GroupServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void createContact() {
        Contact contact = new Contact();
        System.out.println("Введите имя");
        contact.setName(scanner.nextLine());
        contactService.createContact(contact);
    }

    public void searchContact() {
        Contact contact = new Contact();
        System.out.println("Введите имя");
        contact.setName(scanner.nextLine());
        System.out.println(contactService.getContact(contact).getName());
    }

    public void searchGroup() {
        Group group = new Group();
        System.out.println("Введите имя");
        group.setName(scanner.nextLine());
        System.out.println(groupService.getGroup(group).getName());
    }

    public void createGroup() {
        Group group = new Group();
        System.out.println("Введите имя");
        group.setName(scanner.nextLine());
        groupService.createGroup(group);
    }

    public void deleteContact() {
        Contact contact = new Contact();
        System.out.println("Введите имя");
        contact.setName(scanner.nextLine());
        contactService.deleteContact(contact);
    }

    public void deleteGroup() {
        //TODO: удалить контакт через сервис
    }

    public void updateContact() {
        Contact contact = new Contact();
        System.out.println("Введите имя");
        contact.setName(scanner.nextLine());
        contactService.updateContact(contact);
    }

    public void updateGroup() {
        //TODO: обновить группу через Сервис
    }

    public void checkContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        for (Contact contact : contacts) {
            System.out.println(contact.getName());
        }
    }

    public void checkGroups() {
        //TODO: просмотреть группы через Сервис
    }
}
