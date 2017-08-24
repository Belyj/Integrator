package ru.handbook.services.servicesimpl;

import ru.handbook.dao.dbdao.mysql.mysqlfactorydao.MySQLContactFactoryDAO;
import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.dom.domfactorydao.DOMContactFactoryDAOImpl;
import ru.handbook.dao.parsersdao.jackson.jacksonfactorydao.JacksonContactFactoryDAOImpl;
import ru.handbook.dao.parsersdao.sax.saxfactorydao.SAXContactFactoryDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    ContactFactoryDAO contactFactoryDAO = new MySQLContactFactoryDAO();
    ObjectDAO<Contact> contactDAO = contactFactoryDAO.factoryMethod();

    public Contact createContact(Contact contact) {
        return contactDAO.create(contact);
    }

    public Contact getContact(Contact contact) {
        return contactDAO.getByName(contact);
    }

    public Contact getContactByID(Contact contact) {
        return contactDAO.getByID(contact);
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

    public void setDOM() {
        contactFactoryDAO = new DOMContactFactoryDAOImpl();
        contactDAO = contactFactoryDAO.factoryMethod();
    }

    public void setSAX() {
        contactFactoryDAO = new SAXContactFactoryDAOImpl();
        contactDAO = contactFactoryDAO.factoryMethod();
    }

    public void setJackson() {
        contactFactoryDAO = new JacksonContactFactoryDAOImpl();
        contactDAO = contactFactoryDAO.factoryMethod();
    }
}
