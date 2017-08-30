package ru.handbook.services.servicesimpl;

import ru.handbook.dao.hibernatedao.hibernatefactorydao.HibernateGroupFactoryDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateGroupDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateGroupDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    //GroupFactoryDAO groupFactoryDAO = new MySQLGroupFactoryDAO();
    //GroupDAO groupDAO = groupFactoryDAO.factoryMethod();

    HibernateGroupFactoryDAO groupFactoryDAO = new HibernateGroupFactoryDAO();
    HibernateGroupDAO groupDAO = new HibernateGroupDAOImpl();

    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }

    public Group createGroup(Group group) {
        return groupDAO.create(group);
    }

    public List<Group> getGroupByName(Group group) {
        return groupDAO.getByName(group);
    }

    public Group getGroupByID (Group group)  {
        return groupDAO.getByID(group);
    }

    public Group updateGroup(Group group) {
        return groupDAO.update(group);
    }

    public Group deleteGroup(Group group) {
        return groupDAO.delete(group);
    }

    public void removeFromGroup(Contact contact, Group group) {
        //groupDAO.removeFromGroup(contact, group);
    }

    public void addInGroup(Contact contact, Group group) {
        //groupDAO.addInGroup(contact, group);
    }
}
