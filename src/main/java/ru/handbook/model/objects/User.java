package ru.handbook.model.objects;

import javax.persistence.*;

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

    public User(int id) {
        this.name = "";
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