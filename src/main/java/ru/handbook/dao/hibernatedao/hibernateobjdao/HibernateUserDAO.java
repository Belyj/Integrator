package ru.handbook.dao.hibernatedao.hibernateobjdao;

import ru.handbook.model.objects.User;

import java.util.List;

public interface HibernateUserDAO {

    public User getByParams(String login, String password);

    public Float avgContactsInGroups();

    public Float avgCountOfContacts();

    public List<User> unactiveList();

    public List<User> userContactsCount();

    public Float userCount();

    public List<User> userGroupsCount();
}
