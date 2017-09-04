package ru.handbook.model.objects;

import ru.handbook.model.storage.Observable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_table")
public class Group implements Serializable, Observable {

    @Id @GeneratedValue
    @Column(name = "gid")
    private int id = 0;
    @Column(name = "gname")
    private String name= "";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "link_table",
            joinColumns={@JoinColumn(name = "group_id")},
            inverseJoinColumns={@JoinColumn(name = "contact_id")})
    private List<Contact> groupContacts = new ArrayList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "link_table",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private User user = new User();

    public Group() {
        id = 0;
        groupContacts = new ArrayList();
    }

    public Group(String name) {
        id = 0;
        groupContacts = new ArrayList();
        this.name = name;
    }

    public Group(int id) {
        this.id = id;
        groupContacts = new ArrayList();
        name = "";
    }

    public Group(int id, String name, List<Contact> groupContacts) {
        this.id = id;
        this.name = name;
        this.groupContacts = groupContacts;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        groupContacts = new ArrayList();
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
        //observers.add(observer);
    }

    @Override
    public void removeObserver(ru.handbook.view.contactview.Observer observer) {
        //observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
//        for (ru.handbook.view.contactview.Observer o : observers) {
//            o.handleEvent();
//        }
    }

    public List<ru.handbook.view.contactview.Observer> getObservers() {
//        return observers;
        return null;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "link_table",
            joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "gid")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uid")})
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    public void setObservers(List<Observer> observers) {
//        this.observers = observers;
//    }

    public void setGroupContacts(List<Contact> groupContacts) {
        this.groupContacts = groupContacts;
    }

    public List<Contact> getGroupContacts() {
        return groupContacts;
    }
}
