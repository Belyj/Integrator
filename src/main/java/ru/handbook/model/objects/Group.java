package ru.handbook.model.objects;

import ru.handbook.model.storage.Observable;
import ru.handbook.view.contactview.Observer;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable, Observable {

    @Column(name = "gid")
    private int id;
    @Column(name = "gname")
    private String name;

    private List<Contact> groupContacts;
    private List<Observer> observers = new ArrayList();

    public Group() {
        id = 0;
        groupContacts = new ArrayList();
    }

    public Group(String name) {
        id = 0;
        groupContacts = new ArrayList();
        this.name = name;
    }

    public Group(int id, String name, List<Contact> groupContacts) {
        this.id = id;
        this.name = name;
        this.groupContacts = groupContacts;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getInner() {
        return groupContacts;
    }

    public void setInner(List<Contact> contacts) {
        groupContacts = contacts;
    }

    @Override
    public void addObserver(ru.handbook.view.contactview.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ru.handbook.view.contactview.Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ru.handbook.view.contactview.Observer o : observers) {
            o.handleEvent();
        }
    }

    public List<ru.handbook.view.contactview.Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void setGroupContacts(List<Contact> groupContacts) {
        this.groupContacts = groupContacts;
    }

    public List<Contact> getGroupContacts() {

        return groupContacts;
    }
}
