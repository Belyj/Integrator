package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.callquery.CallContactQuery;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.ContactMapperImpl;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySQLContactDAOImpl implements ObjectDAO<Contact> {

    private Driver driver;
    CallContactQuery call = new CallContactQuery();
    private Connection connection;
    ResultSet resultSet;
    DBProperties dbProperties = new DBProperties();
    String query;
    ObjectMapper mapper = new ContactMapperImpl();

    public MySQLContactDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public Contact create(Contact contact) {
        query = call.createContact(contact);
        Contact c = new Contact();
        try (Statement statement = connection.createStatement()){
            resultSet = statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Contact getByName(Contact contact) {
        query = call.getContactByName(contact);
        Contact c = new Contact();
        try (Statement statement = connection.createStatement()) {
            resultSet =  statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Contact update(Contact contact) {
        synchronized (contact) {
            System.out.println("New Contact Name");
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            System.out.println("New Pone Name");
            String newPhone = scanner.nextLine();
            System.out.println("New Skype Name");
            String newSkype = scanner.nextLine();
            System.out.println("New Mail Name");
            String newMail = scanner.nextLine();
            query = call.updateContact(contact, newName, newPhone, newSkype, newMail);
            try (Statement statement = connection.createStatement()) {
                statement.execute(query);
                return contact;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Contact delete(Contact contact) {
        synchronized (contact) {
            query = call.deleteContact(contact);
            try (Statement statement = connection.createStatement()) {
                statement.execute(query);
                return contact;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public List<Contact> getAll() {
        query = call.getAll();
        List<Contact> contacts = new ArrayList();
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            contacts = mapper.listMap(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
