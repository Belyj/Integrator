package ru.handbook.dao.parsersdao.sax.saxfactorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.SAXContactDAOImpl;
import ru.handbook.model.objects.Contact;

public class SAXContactFactoryDAOImpl implements ContactFactoryDAO {
    @Override
    public ObjectDAO factoryMethod() {
        return new SAXContactDAOImpl();
    }
}
