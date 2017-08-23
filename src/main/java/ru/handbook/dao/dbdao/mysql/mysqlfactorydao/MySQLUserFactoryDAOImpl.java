package ru.handbook.dao.dbdao.mysql.mysqlfactorydao;

import ru.handbook.dao.dbdao.mysql.MySQLUserDAOImpl;
import ru.handbook.dao.objectsdao.UserDAO;
import ru.handbook.dao.objectsdao.UserFactoryDAO;

public class MySQLUserFactoryDAOImpl implements UserFactoryDAO{

    @Override
    public UserDAO factoryMethod() {
        return MySQLUserDAOImpl.getInstance();
    }
}
