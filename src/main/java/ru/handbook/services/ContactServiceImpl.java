package ru.handbook.services;

import ru.handbook.model.dao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    ObjectDAO<Contact> contactDAO;

    public List<Contact> getAllContacts() {
        return contactDAO.check();
    }

    public Contact createContact(Contact contact) {
        return  contactDAO.create();
    }

    public Contact searchContact(Contact contact) {
        if (contactDAO.search(contact) != null) {
            return contactDAO.search(contact);
        } else {
            System.out.println("Контакта не существует");
            return null;
        }
    }

    public Contact deleteContact(Contact contact) {
        Contact deletedContact = searchContact(contact);
        contactDAO.delete(deletedContact);
    }

    public Contact updateContact(Contact contact) {
        Contact updateContact = searchContact(contact);
        return contactDAO.update(updateContact);
    }
}
