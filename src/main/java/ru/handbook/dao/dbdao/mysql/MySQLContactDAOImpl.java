package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactDAOImpl implements ObjectDAO<Contact> {

    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    //CallableStatement statement;
    Statement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    String query;

    public MySQLContactDAOImpl() {
        try {
            System.out.println("Creating driver...");
            driver = new Driver();
            System.out.println("Register Driver..");
            DriverManager.registerDriver(driver);
            System.out.println("Create connection...");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    @Override
    public Contact create(Contact contact) {
        return null;
    }

    @Override
    public Contact getByName(Contact contact) {
        query = "{call getContactByName(\"" + contact.getName() + "\", " + "\"RU\"" + ")}";
        Contact c = new Contact();
        try {
            statement = connection.createStatement();
            resultSet =  statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("contact_name");
                int phone = resultSet.getInt("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                c = new Contact(name, phone, skype, mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        query = "{call getContactList(\"" + "RU" + "\")}";
        List<Contact> contacts = new ArrayList();
        Contact contact = new Contact();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }
}
