package ru.handbook.dao.objectsdao.daoimpl.factorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.daoimpl.productdao.GroupDAOImpl;

public class GroupFactoryDAOImpl implements ContactFactoryDAO {

    public GroupDAOImpl factoryMethod() {
        return new GroupDAOImpl();
    }
}
