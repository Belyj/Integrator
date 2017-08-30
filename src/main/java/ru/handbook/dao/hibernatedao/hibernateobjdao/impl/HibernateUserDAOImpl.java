package ru.handbook.dao.hibernatedao.hibernateobjdao.impl;

import com.mysql.jdbc.Driver;
import org.hibernate.Session;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.User;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HibernateUserDAOImpl implements HibernateUserDAO {

    private static volatile HibernateUserDAOImpl instance;
    private Driver driver;
    private List<User> users;
    private User u;
    private Integer count;

    public HibernateUserDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static HibernateUserDAOImpl getInstance() {
        if (instance == null) {
            synchronized (HibernateUserDAOImpl.class) {
                if (instance == null) {
                    instance = new HibernateUserDAOImpl();
                }
            }
        }
        return instance;
    }

    private List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
            return users;
        }
    }

    @Override
    public User getByParams(String login, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            users = session.createCriteria(User.class, login).list();
            for (User user : users) {
                if (user.getPass().equals(password)) {
                    u = user;
                }
            }
            return u;
        }
    }

    @Override
    public Float avgContactsInGroups() {
        return null;
    }

    @Override
    public Float avgCountOfContacts() {
        return null;
    }

    @Override
    public List<User> unactiveList() {
        return null;
    }

    @Override
    public List<User> userContactsCount() {
        return null;
    }

    @Override
    public Float userCount() {
        return null;
    }

    @Override
    public List<User> userGroupsCount() {
        return null;
    }
}
