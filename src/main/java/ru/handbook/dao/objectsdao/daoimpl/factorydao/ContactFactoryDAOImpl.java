package ru.handbook.dao.objectsdao.daoimpl.factorydao;

import ru.handbook.dao.objectsdao.FactoryDAO;
import ru.handbook.dao.objectsdao.daoimpl.productdao.ContactDAOImpl;

public class ContactFactoryDAOImpl implements FactoryDAO {

    public ContactDAOImpl factoryMethod() {
        return new ContactDAOImpl();
    }
}
