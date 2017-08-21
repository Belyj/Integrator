package ru.handbook.dao.dbdao.mysql.callquery;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import static ru.handbook.Main.userInit;

public class CallGroupQuery {

    public String deleteFromGroup(Contact contact, Group group) {
        return "{call removeFromGroup(\"" + contact.getId() + "\", "
                + "\"" + group.getId() + "\", "
                + "\"" + userInit.getUser().getName() + "\"" + " )}";
    }

    public String addInGroup(Contact contact, Group group) {
        return "{call addInGroup(\"" + contact.getId() + "\", " +
                "\"" + group.getId() + "\", "
                + "\"" + userInit.getUser().getName() + "\"" + " )}";
    }

    public String createGroup(Group group) {
        return "{call createGroup(\"" + group.getName() + "\")}";
    }

    public String getByName(Group group) {
        return "{call getGroupByName(\"" + group.getName() + "\", " +
                "\"" + userInit.getUser().getName() + "\"" + ")}";
    }

    public String update(Group group, String newName) {
        return "{call updateGroup(\"" + group.getId() + "\", \"" +
                newName + "\")}";
    }

    public String delete(Group group) {
        return "{call removeGroupByID(\"" + group.getId() + "\")}";
    }

    public String getAll() {
        return "{call getGroupList(\"" + userInit.getUser().getName() + "\")}";
    }
}
