package ru.handbook.services;

import ru.handbook.dao.ContactDAOImpl;
import ru.handbook.model.objects.Contact;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    ContactDAOImpl contactDAO = new ContactDAOImpl();

    public Contact createContact(Contact contact) {
        contactDAO.create(contact);
        return contact;
    }

    public Contact getContact(Contact contact) {
        return contactDAO.getByName(contact);
    }

    public Contact deleteContact(Contact contact) {
        contactDAO.delete(contact);
        System.out.println("контакт удален");
        return contact;
    }

    public Contact updateContact(Contact contact) {
        System.out.println(contactDAO.update(contact).getName());
        return contact;
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAll();
    }
}
