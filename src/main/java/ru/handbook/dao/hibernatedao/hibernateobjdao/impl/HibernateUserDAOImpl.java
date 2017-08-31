package ru.handbook.dao.hibernatedao.hibernateobjdao.impl;

import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.User;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HibernateUserDAOImpl implements HibernateUserDAO {

    private static final Logger log = Logger.getLogger(HibernateUserDAOImpl.class);

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
        log.info("Взять список Пользователей");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
            return users;
        }
    }

    @Override
    public User getByParams(String login, String password) {
        log.info("Взять пользователя по логину " + login + " и паролю " +password);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            log.info("Взять список пользователей по логину " + login);
            session.beginTransaction();
            users = session.createCriteria(User.class, login).list();
            log.info("Найти среди них по паролю " +password);
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
        log.info("Среднее количество контактов в группах");
        return null;
    }

    @Override
    public Float avgCountOfContacts() {
        log.info("Среднее количество контактов у пользователя");
        return null;
    }

    @Override
    public List<User> unactiveList() {
        log.info("Список неактивных пользователей");
        return null;
    }

    @Override
    public List<User> userContactsCount() {
        log.info("Количество контактов у каждого пользователя");
        return null;
    }

    @Override
    public Float userCount() {
        log.info("Количество пользователей");
        return null;
    }

    @Override
    public List<User> userGroupsCount() {
        log.info("Количество групп у пользователей");
        return null;
    }
}