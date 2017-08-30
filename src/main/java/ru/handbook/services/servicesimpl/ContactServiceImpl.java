package ru.handbook.services.servicesimpl;

import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateContactDAO;
import ru.handbook.dao.hibernatedao.hibernatefactorydao.HibernateContactFactoryDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    //ContactFactoryDAO contactFactoryDAO = new MySQLContactFactoryDAO();
    HibernateContactFactoryDAO contactFactoryDAO = new HibernateContactFactoryDAO();
    //ObjectDAO<Contact> contactDAO = contactFactoryDAO.factoryMethod();
    HibernateContactDAO contactDAO = contactFactoryDAO.factoryMethod();

    public Contact createContact(Contact contact) {
        return contactDAO.create(contact);
    }

    public Contact getContactByID(Contact contact) {
        return contactDAO.getByID(contact);
    }

    public List<Contact> getContactByName (Contact contact) {
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
