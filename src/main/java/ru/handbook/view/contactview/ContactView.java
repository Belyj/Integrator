package ru.handbook.view.contactview;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import javax.swing.*;
import java.util.List;

public class ContactView extends JFrame implements Observer {

    private JTextArea view;

    public ContactView() {
        setTitle("Contact view");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 500);
        view = new JTextArea();
        view.setEditable(false);
        view.setLineWrap(true);
        this.add(view);
        this.setVisible(true);
        DataStorage.getInstance().addObserver(this);
    }

    public void handleEvent() {
        view.repaint();
        List<Contact> contacts = DataStorage.getInstance().getContacts();
        for (Contact contact : contacts) {
            this.view.setText(this.view.getText() + "\n" + contact.getName() + " " + contact.getId());
        }
    }
}
