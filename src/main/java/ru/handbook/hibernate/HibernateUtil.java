package ru.handbook.hibernate;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {

    private static final Logger log = Logger.getLogger(HibernateUtil.class);

    private static final SessionFactory sessionFactory;
    static {
        try {
            log.info("Создание сессии по конфигурационному файлу");
            sessionFactory = new Configuration().configure(new File(new File("").getAbsolutePath() +
                                                            "/src/main/resources/hibernate/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Конфигурационный файл не найден");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}