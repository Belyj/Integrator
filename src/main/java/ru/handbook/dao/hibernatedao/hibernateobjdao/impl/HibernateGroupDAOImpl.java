package ru.handbook.dao.hibernatedao.hibernateobjdao.impl;

import com.mysql.jdbc.Driver;
import org.hibernate.Session;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateGroupDAO;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.Group;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HibernateGroupDAOImpl implements HibernateGroupDAO {

    private static volatile HibernateGroupDAOImpl instance;
    private Driver driver;
    List<Group> groups;
    Group g;

    public HibernateGroupDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static HibernateGroupDAOImpl getInstance() {
        if (instance == null) {
            synchronized (HibernateGroupDAOImpl.class) {
                if (instance == null) {
                    instance = new HibernateGroupDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Group> getByName(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            groups = session.createCriteria(Group.class, group.getName()).list();
            return groups;
        }
    }

    @Override
    public Group getByID(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            g = session.load(Group.class, group.getId());
            return g;
        }
    }

    @Override
    public List<Group> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            groups = session.createCriteria(Group.class).list();
            return groups;
        }
    }

    @Override
    public Group create(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
            return group;
        }
    }

    @Override
    public Group update(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            return group;
        }
    }

    @Override
    public Group delete(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();
            return group;
        }
    }
}
