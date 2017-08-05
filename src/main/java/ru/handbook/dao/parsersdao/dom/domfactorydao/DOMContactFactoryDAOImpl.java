package ru.handbook.dao.parsersdao.dom.domfactorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.dom.DOMContactDAOImpl;
import ru.handbook.model.objects.Contact;

public class DOMContactFactoryDAOImpl implements ContactFactoryDAO {
    @Override
    public ObjectDAO factoryMethod() {
        return new DOMContactDAOImpl();
    }
}
