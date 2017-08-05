package ru.handbook.dao.objectsdao.daoimpl.factorydao;

import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.daoimpl.productdao.ContactDAOImpl;

public class ContactFactoryDAOImpl implements ContactFactoryDAO {

    public ContactDAOImpl factoryMethod() {
        return new ContactDAOImpl();
    }
}
