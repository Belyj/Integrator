package ru.handbook.dao.dbdao.mysql.mysqlfactorydao;

import ru.handbook.dao.dbdao.mysql.MySQLGroupDAOImpl;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;

public class MySQLGroupFactoryDAO implements GroupFactoryDAO {
    @Override
    public GroupDAO factoryMethod() {
        return new MySQLGroupDAOImpl();
    }
}
