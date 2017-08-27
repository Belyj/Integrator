package ru.handbook.services.servicesimpl;

import ru.handbook.dao.dbdao.mysql.mysqlfactorydao.MySQLGroupFactoryDAO;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.GroupFactoryDAO;
import ru.handbook.dao.parsersdao.dom.domfactorydao.DOMGroupFactoryDAOImpl;
import ru.handbook.dao.parsersdao.jackson.jacksonfactorydao.JacksonGroupFactoryDAOImpl;
import ru.handbook.dao.parsersdao.sax.saxfactorydao.SAXGroupFactoryDAOImpl;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    GroupFactoryDAO groupFactoryDAO = new MySQLGroupFactoryDAO();
    GroupDAO groupDAO = groupFactoryDAO.factoryMethod();


    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }

    public Group createGroup(Group group) {
        return groupDAO.create(group);
    }

    public Group getGroup(Group group) {
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
        groupDAO.removeFromGroup(contact, group);
    }

    public void addInGroup(Contact contact, Group group) {
        groupDAO.addInGroup(contact, group);
    }

    public void setDOM() {
        groupFactoryDAO = new DOMGroupFactoryDAOImpl();
        groupDAO = groupFactoryDAO.factoryMethod();
    }

    public void setSAX() {
        groupFactoryDAO = new SAXGroupFactoryDAOImpl();
        groupDAO = groupFactoryDAO.factoryMethod();

    }

    public void setJackson() {
        groupFactoryDAO = new JacksonGroupFactoryDAOImpl();
        groupDAO = groupFactoryDAO.factoryMethod();
    }
}
