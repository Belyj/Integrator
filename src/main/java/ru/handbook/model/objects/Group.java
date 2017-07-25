package ru.handbook.model.objects;

import java.util.List;

public class Group implements Objects {

    private String name;
    private List<String> groupContacts;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getInner() {
        return groupContacts;
    }

    public void setInner(List<String> contacts) {
        groupContacts = contacts;
    }
}
