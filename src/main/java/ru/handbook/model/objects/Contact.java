package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import ru.handbook.view.contactview.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Contact")
public class Contact implements Serializable, Observable {

    List<Observer> observers = new ArrayList();
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "phone")
    private String phone;
    @JacksonXmlProperty(localName = "skype")
    private String skype;
    @JacksonXmlProperty(localName = "mail")
    private String mail;

    public Contact() {
        id = 0;
        skype = "";
        mail = "";
    }

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

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "id: " + id + "\t" +
                "name: " + name + "\t" +
                "phone: " + phone + "\t" +
                "skype: " + skype + "\t" +
                "mail: " + mail;
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent();
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
