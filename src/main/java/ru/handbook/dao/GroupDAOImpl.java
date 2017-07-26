package ru.handbook.dao;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class GroupDAOImpl implements ObjectDAO<Group> {

    DataStorage source = DataStorage.getInstance();
    List<Group> groupsBase = source.getGroups();

    public Group getByName(Group group) {
        return source.getGroupByName(group.getName());
    }

    public Group update(Group group) {
        return group;
    }

    public void delete(Group group) {
        Group deletedGroup = getByName(group);
        groupsBase.remove(deletedGroup);
    }

    public List<Group> getAll() {
        return groupsBase;
    }

    public void create(Group group) {
        source.setGroup(group);
    }
}
