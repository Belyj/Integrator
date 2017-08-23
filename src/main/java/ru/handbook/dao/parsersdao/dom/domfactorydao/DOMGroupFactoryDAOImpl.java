package ru.handbook.dao.parsersdao.dom.domfactorydao;

import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;
import ru.handbook.dao.parsersdao.dom.DOMGroupDAOImpl;

public class DOMGroupFactoryDAOImpl implements GroupFactoryDAO {

    public GroupDAO factoryMethod() {
        return new DOMGroupDAOImpl();
    }
}
