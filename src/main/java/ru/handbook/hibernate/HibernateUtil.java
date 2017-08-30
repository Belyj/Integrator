package ru.handbook.hibernate;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.io.File;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure(new File(new File("").getAbsolutePath() +
                                                            "/src/main/resources/hibernate/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}