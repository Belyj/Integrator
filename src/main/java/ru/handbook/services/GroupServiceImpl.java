package ru.handbook.services;

import ru.handbook.dao.GroupDAOImpl;
import ru.handbook.model.objects.Group;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    GroupDAOImpl groupDAO = new GroupDAOImpl();

    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }

    public Group createGroup(Group group) {
        groupDAO.create(group);
        return group;
    }

    public Group getGroup(Group group) {
        return groupDAO.getByName(group);
    }

    public Group updateGroup(Group group) {
        System.out.println(groupDAO.update(group).getName());
        return group;
    }

    public Group deleteGroup(Group group) {
        groupDAO.delete(group);
        System.out.println("группа удалена");
        return group;
    }
}
