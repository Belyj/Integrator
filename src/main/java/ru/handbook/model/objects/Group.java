package ru.handbook.model.objects;

import ru.handbook.model.utilites.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private int id;
    private List<Contact> groupContacts;

    public Group() {
        id = Integer.parseInt(new IdGenerator().generateGroupId());
        groupContacts = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Contact> getInner() {
        return groupContacts;
    }

    public void setInner(List<Contact> contacts) {
        groupContacts = contacts;
    }
}
