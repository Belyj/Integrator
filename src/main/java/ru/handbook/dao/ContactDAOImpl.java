package ru.handbook.dao;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class ContactDAOImpl implements ObjectDAO<Contact> {

    DataStorage source = DataStorage.getInstance();
    List<Contact> contactsBase = source.getContacts();

    public void delete(Contact c) {
        Contact deleteContact = getByName(c);
        contactsBase.remove(deleteContact);
    }

    public List<Contact> getAll() {
        return contactsBase;
    }

    public void create(Contact contact) {
        source.setContact(contact);
    }

    public Contact getByName(Contact contact) {
        return source.getContactByName(contact.getName());
    }

    public Contact update(Contact contact) {
        Contact c = getByName(contact);
        System.out.println("Введите новое имя");
        c.setName(new Scanner(System.in).nextLine());
        return c;
    }
}
