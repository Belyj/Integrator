package ru.handbook.view;

import ru.handbook.model.objects.User;

import java.sql.*;
import java.util.Scanner;

public class UserInit {

    Scanner scanner = new Scanner(System.in);
    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    Statement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    String query;
    User user;

    public User getUser() {
        return user;
    }

    public UserInit() {
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String pass = scanner.nextLine();
        connect();
        user = getByName(login, pass);
    }

    private void connect() {
        try {
            driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    private User getByName(String login, String pass) {
        query = "{call getUserByName(\"" + login + "\", " + "\"" + pass + "\"" + ")}";
        User u = new User();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("uid");
                String name = resultSet.getString("uname");
                u.setId(id);
                u.setName(name);
            }
            System.out.println("welcome: " + u.getName());
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}