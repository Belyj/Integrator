package ru.handbook.model.dao;

import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

public class GroupDAOImpl implements ObjectDAO {

    DataStorage source = DataStorage.getInstance();

    public Group search(String name) {
        for (Group group : source.getGroups()) {
            if (group.getName().equals(name)) {
                System.out.println(group.getName());
                return group;
            }
        }
        System.out.println("Группы не существует");
        return null;
    }

    public void update(String name, String newName) {
        search(name).setName(newName);
    }

    public void delete(String name) {
        Group deletedGroup = search(name);
        source.getGroups().remove(deletedGroup);
    }

    public void check() {
        for (Group group : source.getGroups()) {
            System.out.println(group.getName());
        }
    }
}
