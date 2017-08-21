package ru.handbook.dao.parsersdao.jackson.jacksonfactorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.jackson.JacksonContactDAOImpl;
import ru.handbook.model.objects.Contact;

public class JacksonContactFactoryDAOImpl implements ContactFactoryDAO {

    @Override
    public ObjectDAO factoryMethod() {
        return new JacksonContactDAOImpl();
    }
}
