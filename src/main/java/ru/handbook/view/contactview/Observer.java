package ru.handbook.view.contactview;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface Observer {

    void handleEvent(List<Contact> contacts);
}
