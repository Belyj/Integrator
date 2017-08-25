package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.callquery.CallContactQuery;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.ContactMapperImpl;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactDAOImpl implements ObjectDAO<Contact> {

    private static volatile MySQLContactDAOImpl instance;
    CallContactQuery call = new CallContactQuery();
    ResultSet resultSet;
    DBProperties dbProperties = new DBProperties();
    String query;
    ObjectMapper mapper = new ContactMapperImpl();
    private Driver driver;

    public MySQLContactDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static MySQLContactDAOImpl getInstance() {
        if (instance == null) {
            synchronized (MySQLContactDAOImpl.class) {
                if (instance == null) {
                    instance = new MySQLContactDAOImpl();
                }
            }
        }
        return instance;
    }

    public synchronized Contact create(Contact contact) {
        query = call.createContact(contact);
        Contact c = new Contact();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
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
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Contact getByID(Contact contact) {
        query = call.getContactByID(contact);
        Contact c = new Contact();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public synchronized Contact update(Contact contact) {
        Contact c;
        query = call.updateContact(contact, contact.getName(), contact.getPhone(), contact.getSkype(), contact.getMail());
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
            resultSet.close();
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Contact delete(Contact contact) {
        query = call.deleteContact(contact);
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            return contact;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> getAll() {
        query = call.getAll();
        List<Contact> contacts = new ArrayList();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            contacts = mapper.listMap(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
