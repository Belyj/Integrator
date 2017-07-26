package ru.handbook.view.contactview;

import ru.handbook.model.objects.Contact;

import java.util.List;

public class ContactView implements Observer {

    public void handleEvent(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println("");
        }
    }
}
