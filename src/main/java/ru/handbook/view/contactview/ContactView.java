package ru.handbook.view.contactview;

import java.util.List;

public class ContactView implements Observer {

    public void handleEvent(List<String> contacts) {
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }
}
