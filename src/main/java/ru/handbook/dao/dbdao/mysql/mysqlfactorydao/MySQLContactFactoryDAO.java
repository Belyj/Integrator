package ru.handbook.dao.dbdao.mysql.mysqlfactorydao;

import ru.handbook.dao.dbdao.mysql.MySQLContactDAOImpl;
import ru.handbook.dao.objectsdao.ContactFactoryDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;

public class MySQLContactFactoryDAO implements ContactFactoryDAO {
    @Override
    public ObjectDAO factoryMethod() {
        return MySQLContactDAOImpl.getInstance();
    }
}
