package ru.handbook.dao.parsersdao.sax.saxfactorydao;

import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;
import ru.handbook.dao.parsersdao.sax.SAXGroupDAOImpl;

public class SAXGroupFactoryDAOImpl implements GroupFactoryDAO {
    @Override
    public GroupDAO factoryMethod() {
        return new SAXGroupDAOImpl();
    }
}
