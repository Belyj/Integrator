package ru.handbook.dao.hibernatedao.hibernatefactorydao;

import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateGroupDAOImpl;

public class HibernateGroupFactoryDAO {
    public HibernateGroupDAOImpl factoryMethod() {
        return new HibernateGroupDAOImpl();
    }
}
