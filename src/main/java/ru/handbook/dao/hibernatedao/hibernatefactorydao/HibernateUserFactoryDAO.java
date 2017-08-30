package ru.handbook.dao.hibernatedao.hibernatefactorydao;

import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateUserDAOImpl;

public class HibernateUserFactoryDAO {
    public HibernateUserDAO factoryMethod() {
        return new HibernateUserDAOImpl();
    }

}
