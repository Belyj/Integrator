package ru.handbook.dao.parsersdao.sax.saxfactorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.SAXGroupDAOImpl;
import ru.handbook.model.objects.Group;

public class SAXGroupFactoryDAOImpl implements GroupFactoryDAO {
    @Override
    public GroupDAO factoryMethod() {
        return new SAXGroupDAOImpl();
    }
}
