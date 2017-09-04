package ru.handbook.model.objects;

import ru.handbook.model.storage.Observable;
import ru.handbook.view.contactview.Observer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_table")
public class Contact implements Observable {

    @Column(name = "cid")
    private int id = 0;
    @Column(name = "cname")
    private String name = "";
    @Column(name = "phone")
    private String phone = "";
    @Column(name = "skype")
    private String skype = "";
    @Column(name = "mail")
    private String mail = "";
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "link_table",
            joinColumns = {@JoinColumn(name = "contact_id", referencedColumnName = "cid")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uid")})
    private User user = new User();

    public Contact() {
    }

    private List<Observer> observers = new ArrayList();

    public Contact(int id) {
        this.id = id;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact(int id, String name, String phone, String skype, String mail) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.skype = skype;
        this.mail = mail;
    }

    public Contact(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Id @GeneratedValue
    @Column(name = "cid", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cname", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", nullable = false, length = 256)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "skype", nullable = false, length = 256)
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Column(name = "mail", nullable = false, length = 256)
    public String getMail() {
        return mail;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "link_table",
            joinColumns = {@JoinColumn(name = "contact_id", referencedColumnName = "cid")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uid")})
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "id: " + id + "\t" +
                "name: " + name + "\t" +
                "phone: " + phone + "\t" +
                "skype: " + skype + "\t" +
                "mail: " + mail;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent();
        }
    }
}