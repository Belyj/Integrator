package ru.handbook.model.dao;

import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.util.List;

public class GroupDAOImpl implements ObjectDAO<Group> {

    DataStorage source = DataStorage.getInstance();
    List<Group> groupsBase = source.getGroups();

    public Group search(Group g) {
        for (Group group : groupsBase) {
            if (group.equals(g)) {
                System.out.println(group.getName());
                return group;
            }
        }
        System.out.println("Группы не существует");
        return null;
    }

    public void update(Group g, String newName) {
        Group updateGroup = search(g);
        updateGroup.setName(newName);
    }

    public void delete(Group g) {
        Group deletedGroup = search(g);
        groupsBase.remove(deletedGroup);
    }

    public List<Group> check() {
        for (Group group : groupsBase) {
            System.out.println(group.getName());
        }
        return source.getGroups();
    }

    public void create() {
        source.setGroup( new Group());
    }
}
