package ru.handbook.model.storage;

import ru.handbook.view.contactview.Observer;

import java.util.ArrayList;
import java.util.List;

public class DataStorage implements Observable {

    private static final long serialVersionUID = -8322155900638738350L;
    private static volatile DataStorage instance;
    private List<Observer> observers = new ArrayList();
    private List<String> contacts = new ArrayList();

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

    public void createContact() {
        System.out.println("Созан контакт");
    }

    public void createGroup() {
        System.out.println("Созана группа");
    }

    public void deleteContact() {
        System.out.println("Удален контакт");
    }

    public void deleteGroup() {
        System.out.println("Удалена группа");
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
