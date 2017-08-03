package ru.handbook.dao.parsersdao.jackson.jacksonfactorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

public class JacksonContactFactoryDAOImpl implements FactoryDAO<Contact> {
    @Override
    public ObjectDAO factoryMethod() {
        return null;
    }
}
