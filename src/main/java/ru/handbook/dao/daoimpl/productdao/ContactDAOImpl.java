package ru.handbook.dao.daoimpl.productdao;
import ru.handbook.dao.ObjectDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class ContactDAOImpl implements ObjectDAO<Contact> {

    DataStorage source = DataStorage.getInstance();

    public Contact delete(Contact contact) {
        Contact deleteContact = getByName(contact);
        source.getContacts().remove(deleteContact);
        return deleteContact;
    }

    public List<Contact> getAll() {
        return source.getContacts();
    }

    public Contact create(Contact contact) {
        return source.setContact(contact);
    }

    public Contact getByName(Contact contact) {
        return source.getContactByName(contact.getName());
    }

    public Contact update(Contact contact) {
        int id = source.getContactByName(contact.getName()).getId();
        source.getContacts().remove(source.getContactByName(contact.getName()));
        System.out.println("Введите новое имя");
        contact.setName(new Scanner(System.in).nextLine());
        contact.setId(id);
        source.getContacts().add(contact);
        return source.getContactByName(contact.getName());
    }
}
