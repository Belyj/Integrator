package ru.handbook.dao.dbdao.mysql.callquery;

public class CallUserQuery {

    public String getUserByName(String login, String password) {
        return "{call getUserByName(\"" + login + "\", " +
                "\"" + password + "\"" + ")}";
    }

    public String unactiveList() {
        return "{call unactiveList()}";
    }

    public String userContactsCount() {
        return "{call userContactsCount()}";
    }

    public String userGroupsCount() {
        return "{call userGroupsCount()}";
    }

    public String userCount() {
        return "{call userCount()}";
    }

    public String avgContactsInGroups() {
        return "{call avgContactsInGroups()}";
    }

    public String avgCountOfContacts() {
        return "{call avgCountOfContacts()}";
    }
}