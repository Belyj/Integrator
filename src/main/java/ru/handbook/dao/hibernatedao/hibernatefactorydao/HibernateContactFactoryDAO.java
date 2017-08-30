package ru.handbook.dao.hibernatedao.hibernatefactorydao;

import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateContactDAOImpl;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateContactDAO;

public class HibernateContactFactoryDAO {

    public HibernateContactDAO factoryMethod() {
        return new HibernateContactDAOImpl();
    }
}
