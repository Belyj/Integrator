package ru.handbook.dao.parsersdao.dom.domfactorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.dom.DOMGroupDAOImpl;
import ru.handbook.model.objects.Group;

public class DOMGroupFactoryDAOImpl implements FactoryDAO<Group> {
    @Override
    public ObjectDAO factoryMethod() {
        return new DOMGroupDAOImpl();
    }
}
