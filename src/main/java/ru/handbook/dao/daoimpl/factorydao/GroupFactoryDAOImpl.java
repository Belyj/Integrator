package ru.handbook.dao.daoimpl.factorydao;

import ru.handbook.dao.FactoryDAO;
import ru.handbook.dao.daoimpl.productdao.GroupDAOImpl;

public class GroupFactoryDAOImpl implements FactoryDAO {

    public GroupDAOImpl factoryMethod() {
        return new GroupDAOImpl();
    }
}
