package ru.handbook.controller;

import ru.handbook.model.storage.DataStorage;

public class MenuControllerDAOImpl implements ContactControllerDAO, GroupControllerDAO {

    DataStorage source = DataStorage.getInstance();
    public void createContact() {
        source.createContact();
    }

    public void deleteContact() {
        source.deleteContact();
    }

    public void createGroup() {
        source.createGroup();
    }

    public void deleteGroup() {
        source.deleteGroup();
    }
}
