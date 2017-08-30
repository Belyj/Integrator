package ru.handbook.dao.hibernatedao;

import com.mysql.jdbc.Driver;
import org.hibernate.Session;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.Contact;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HibernateContactDAOImpl implements HibernateContactDAO {

    private static volatile HibernateContactDAOImpl instance;
    private Driver driver;
    List<Contact> contacts;
    Contact c;

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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            contacts = session.createCriteria(Contact.class, contact.getName()).list();
            return contacts;
        }
    }

    @Override
    public Contact getByID(Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            c = session.load(Contact.class, contact.getId());
            return c;
        }
    }

    @Override
    public List<Contact> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            contacts = session.createCriteria(Contact.class).list();
            return contacts;
        }
    }

    @Override
    public Contact create(Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
            return contact;
        }
    }

    @Override
    public Contact update(Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(contact);
            session.getTransaction().commit();
            return contact;
        }
    }

    @Override
    public Contact delete(Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(contact);
            session.getTransaction().commit();
            return contact;
        }
    }
}
