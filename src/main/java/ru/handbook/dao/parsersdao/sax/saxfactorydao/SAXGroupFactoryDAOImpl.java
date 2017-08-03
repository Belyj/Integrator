package ru.handbook.dao.parsersdao.sax.saxfactorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.SAXGroupDAOImpl;
import ru.handbook.model.objects.Group;

public class SAXGroupFactoryDAOImpl implements FactoryDAO<Group> {
    @Override
    public ObjectDAO factoryMethod() {
        return new SAXGroupDAOImpl();
    }
}
