package ru.handbook.services;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact createContact(Contact contact);

    Contact searchContact(Contact contact);

    Contact deleteContact(Contact contact);

    Contact updateContact(Contact contact);
}
