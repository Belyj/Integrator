package ru.handbook.dao.daoimpl.factorydao;

import ru.handbook.dao.FactoryDAO;
import ru.handbook.dao.daoimpl.productdao.ContactDAOImpl;

public class ContactFactoryDAOImpl implements FactoryDAO {

    public ContactDAOImpl factoryMethod() {
        return new ContactDAOImpl();
    }
}
