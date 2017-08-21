package ru.handbook.dao.parsersdao.dom.domfactorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.dom.DOMGroupDAOImpl;
import ru.handbook.model.objects.Group;

public class DOMGroupFactoryDAOImpl implements GroupFactoryDAO {

    public GroupDAO factoryMethod() {
        return new DOMGroupDAOImpl();
    }
}
