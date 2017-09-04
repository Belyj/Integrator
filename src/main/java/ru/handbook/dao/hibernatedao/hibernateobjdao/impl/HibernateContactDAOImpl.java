package ru.handbook.dao.hibernatedao.hibernateobjdao.impl;

import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateContactDAO;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.Contact;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.handbook.Main.userInit;

public class HibernateContactDAOImpl implements HibernateContactDAO {

    private static final Logger log = Logger.getLogger(HibernateContactDAOImpl.class);

    private static volatile HibernateContactDAOImpl instance;
    private Driver driver;
    List<Contact> contacts;

    public HibernateContactDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static HibernateContactDAOImpl getInstance() {
        if (instance == null) {
            synchronized (HibernateContactDAOImpl.class) {
                if (instance == null) {
                    instance = new HibernateContactDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Contact> getByName(Contact contact) {
        log.info("Взять список конатктов по имени " + contact.getName());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            contacts = session.createCriteria(Contact.class, contact.getName()).list();
            return contacts;
        }
    }

    @Override
    public Contact getByID(Contact contact) {
        log.info("Взять конаткт по ID " + contact.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Contact.class);
            List<Criteria> criteriaList = criteria.list();
            if (criteriaList.isEmpty()) {
                return (Contact) criteriaList.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Contact> getAll() {
        log.info("Взять список контактов");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            contacts = session.createCriteria(Contact.class).list();
            List<Contact> filterById = new ArrayList();
            for (Contact c : contacts) {
                if (c.getUser() != null) {
                    if (c.getUser().getId() == userInit.getUser().getId()) {
                        filterById.add(c);
                    }
                }
            }
            return filterById;
        }
    }

    @Override
    public Contact create(Contact contact) {
        log.info("внести в базу конаткт " + contact.getName());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
            contacts = getByName(contact);
            return contacts.get(contacts.size() - 1);
        }
    }

    @Override
    public Contact update(Contact contact) {
        log.info("Обновить конаткт " + contact.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(contact);
            session.getTransaction().commit();
            return getByID(contact);
        }
    }

    @Override
    public Contact delete(Contact contact) {
        log.info("Удалить конаткт " + contact.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(contact);
            session.getTransaction().commit();
            return contact;
        }
    }
}
