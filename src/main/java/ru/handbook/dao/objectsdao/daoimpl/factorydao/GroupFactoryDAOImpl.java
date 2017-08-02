package ru.handbook.dao.objectsdao.daoimpl.factorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.daoimpl.productdao.GroupDAOImpl;

public class GroupFactoryDAOImpl implements FactoryDAO {

    public GroupDAOImpl factoryMethod() {
        return new GroupDAOImpl();
    }
}
