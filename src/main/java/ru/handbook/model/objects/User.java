package ru.handbook.model.objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User {

    @Id @GeneratedValue
    @Column(name = "uid")
    private int id = 0;
    @Column(name = "uname")
    private String name = "";
    @Column(name = "pass")
    private String pass = "";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "link_table",
            joinColumns={@JoinColumn(name = "user_id")},
            inverseJoinColumns={@JoinColumn(name = "contact_id")})
    private List<Contact> userContacts ;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "link_table",
            joinColumns={@JoinColumn(name = "user_id")},
            inverseJoinColumns={@JoinColumn(name = "group_id")})
    private List<Group> userGroups ;

    public void setUserContacts(List<Contact> userContacts) {
        this.userContacts = userContacts;
    }

    public void setUserGroups(List<Group> userGroups) {
        this.userGroups = userGroups;
    }

    public List<Contact> getUserContacts() {

        return userContacts;
    }

    public List<Group> getUserGroups() {
        return userGroups;
    }

    private int count;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public User(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
