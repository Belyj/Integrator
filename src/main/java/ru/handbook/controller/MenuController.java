package ru.handbook.controller;

import ru.handbook.model.storage.DataStorage;

public class MenuController implements ContactController, GroupController {

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
