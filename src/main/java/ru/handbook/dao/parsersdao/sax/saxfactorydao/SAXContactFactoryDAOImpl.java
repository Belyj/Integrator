package ru.handbook.dao.parsersdao.sax.saxfactorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.SAXContactDAOImpl;
import ru.handbook.model.objects.Contact;

public class SAXContactFactoryDAOImpl implements FactoryDAO<Contact> {
    @Override
    public ObjectDAO factoryMethod() {
        return new SAXContactDAOImpl();
    }
}
