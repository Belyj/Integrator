package ru.handbook.services.servicesimpl;

import ru.handbook.dao.daoimpl.factorydao.GroupFactoryDAOImpl;
import ru.handbook.dao.daoimpl.productdao.GroupDAOImpl;
import ru.handbook.model.objects.Group;
import ru.handbook.services.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    GroupFactoryDAOImpl groupFactoryDAO = new GroupFactoryDAOImpl();
    GroupDAOImpl groupDAO = groupFactoryDAO.factoryMethod();

    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }

    public Group createGroup(Group group) {
        return groupDAO.create(group);
    }

    public Group getGroup(Group group) {
        return groupDAO.getByName(group);
    }

    public Group updateGroup(Group group) {
        return groupDAO.update(group);
    }

    public Group deleteGroup(Group group) {
        return groupDAO.delete(group);
    }
}
