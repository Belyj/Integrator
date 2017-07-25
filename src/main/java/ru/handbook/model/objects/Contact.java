package ru.handbook.model.objects;

import java.util.List;

public class Contact implements Objects {

    private String name;
    private List<String> contactGroups;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getInner() {
        return contactGroups;
    }

    public void setInner(List<String> groups) {
        contactGroups = groups;
    }
}
