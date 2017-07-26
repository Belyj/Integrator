package ru.handbook.services.servicesimpl;

import ru.handbook.dao.daoimpl.ContactDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    ContactDAOImpl contactDAO = new ContactDAOImpl();

    public Contact createContact(Contact contact) {
        return contactDAO.create(contact);
    }

    public Contact getContact(Contact contact) {
        return contactDAO.getByName(contact);
    }

    public Contact deleteContact(Contact contact) {
        return contactDAO.delete(contact);
    }

    public Contact updateContact(Contact contact) {
        return contactDAO.update(contact);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAll();
    }
}
