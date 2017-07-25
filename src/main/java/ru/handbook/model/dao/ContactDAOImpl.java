package ru.handbook.model.dao;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.util.List;

public class ContactDAOImpl implements ObjectDAO<Contact> {

    DataStorage source = DataStorage.getInstance();
    List<Contact> contactsBase = source.getContacts();

    public Contact search(Contact c) {
        for (Contact contact : contactsBase) {
            if (contact.equals(c)) {
                System.out.println(contact.getName());
                return contact;
            }
        }
        return null;
    }

    public void update(Contact c, String newName) {
        c.setName(newName);
    }

    public void delete(Contact c) {
        contactsBase.remove(c);
    }

    public List<Contact> check() {
        return contactsBase;
    }

    public void create() {
        source.setContact( new Contact());
    }
}
