package ru.handbook.model.storage;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.view.contactview.Observer;

import java.util.ArrayList;
import java.util.List;

public class DataStorage implements Observable {

    private static final long serialVersionUID = -8322155900638738350L;
    private static volatile DataStorage instance;
    private List<Observer> observers = new ArrayList();
    private List<Contact> contacts = new ArrayList();
    private List<Group> groups = new ArrayList();

    private DataStorage() {
    }

    public static DataStorage getInstance() {
        if (instance == null) {
            synchronized (DataStorage.class) {
                if (instance == null) {
                    instance = new DataStorage();
                }
            }
        }
        return instance;
    }

    public void setContact(Contact contact) {

        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContactByName(String name) {
        Contact searcheble;
        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                searcheble = contact;
                return searcheble;
            }
        }
        System.out.println("Контак с таким именем не существует");
        return null;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Group getGroupByName(String name) {
        Group searcheble;
        for (Group group: groups) {
            if (group.getName().equals(name)) {
                searcheble = group;
                return searcheble;
            }
        }
        System.out.println("Контак с таким именем не существует");
        return null;
    }

    public void setGroup(Group group) {
        groups.add(group);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(contacts);
        }
    }
}
