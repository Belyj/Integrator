package ru.handbook.dao.hibernatedao.hibernateobjdao.impl;

import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateGroupDAO;
import ru.handbook.hibernate.HibernateUtil;
import ru.handbook.model.objects.Group;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static ru.handbook.Main.userInit;

public class HibernateGroupDAOImpl implements HibernateGroupDAO {

    private static final Logger log = Logger.getLogger(HibernateGroupDAOImpl.class);

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
        log.info("Взять список групп по имени " + group.getName());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            groups = session.createCriteria(Group.class, group.getName()).list();
            return groups;
        }
    }

    @Override
    public Group getByID(Group contact) {
        log.info("Взять конаткт по ID " + contact.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Group.class);
            List<Criteria> criteriaList = criteria.list();
            if (criteriaList.isEmpty()) {
                return (Group) criteriaList.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Group> getAll() {
        log.info("Взять список групп");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            groups = session.createCriteria(Group.class).list();
            return groups;
        }
    }

    @Override
    public Group create(Group group) {
        log.info("Создать группу " + group.getName());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
            return group;
        }
    }

    @Override
    public Group update(Group group) {
        log.info("Обнвонить группу" + group.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            return group;
        }
    }

    @Override
    public Group delete(Group group) {
        log.info("Удалить группу" + group.getId());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();
            return group;
        }
    }
}
