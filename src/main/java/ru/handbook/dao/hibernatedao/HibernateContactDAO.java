package ru.handbook.dao.hibernatedao;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface HibernateContactDAO {

    List<Contact> getByName(Contact contact);
    Contact getByID(Contact contact);
    List<Contact> getAll();
    Contact create(Contact contact);
    Contact update(Contact contact);
    Contact delete(Contact contact);
}
