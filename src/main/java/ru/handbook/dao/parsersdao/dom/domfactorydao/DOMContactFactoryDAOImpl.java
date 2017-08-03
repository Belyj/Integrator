package ru.handbook.dao.parsersdao.dom.domfactorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.dom.DOMContactDAOImpl;
import ru.handbook.model.objects.Contact;

public class DOMContactFactoryDAOImpl implements FactoryDAO<Contact> {
    @Override
    public ObjectDAO factoryMethod() {
        return new DOMContactDAOImpl();
    }
}
