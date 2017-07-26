package ru.handbook.dao;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class ContactDAOImpl implements ObjectDAO<Contact> {

    DataStorage source = DataStorage.getInstance();
    List<Contact> contactsBase = source.getContacts();

    public void delete(Contact contact) {
        Contact deleteContact = getByName(contact);
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
        return contact;
    }
}
