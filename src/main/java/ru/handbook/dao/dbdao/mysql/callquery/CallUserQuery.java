package ru.handbook.dao.dbdao.mysql.callquery;

public class CallUserQuery {

    public String getUserByName(String login, String password) {
        return "{call getGroupByName(\"" + login + "\", " +
                "\"" + password + "\"" + ")}";
    }
}
