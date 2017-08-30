package ru.handbook.dao.hibernatedao;

public class HibernateContactFactoryDAOImpl {

    public HibernateContactDAO factoryMethod() {
        return new HibernateContactDAOImpl();
    }
}
