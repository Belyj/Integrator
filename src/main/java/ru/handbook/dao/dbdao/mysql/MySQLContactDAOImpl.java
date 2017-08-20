package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.ContactMapperImpl;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.view.contactview.Observer;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.handbook.Main.userInit;

public class MySQLContactDAOImpl implements ObjectDAO<Contact> {

    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    Statement statement;
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
        query = "{call createContact(\"" + contact.getName() + "\")}";
        Contact c = new Contact();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
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
        return c;
    }

    public Contact getByName(Contact contact) {
        query = "{call getContactByName(\"" + contact.getName() + "\", " +
                "\"" + userInit.getUser().getName() + "\"" + ")}";
        Contact c = new Contact();
        try {
            statement = connection.createStatement();
            resultSet =  statement.executeQuery(query);
            c = (Contact) mapper.map(resultSet);
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
        return c;
    }

    public Contact update(Contact contact) {
        System.out.println("New Contact Name");
        Scanner scanner = new Scanner(System.in);
        String newName = scanner.nextLine();
        System.out.println("New Pone Name");
        String newPhone = scanner.nextLine();
        System.out.println("New Skype Name");
        String newSkype = scanner.nextLine();
        System.out.println("New Mail Name");
        String newMail = scanner.nextLine();
        query = "{call updateContact(\"" + contact.getId()+ "\", \"" +
                                            newName + "\", \"" +
                                            newPhone + "\", \"" +
                                            newSkype + "\", \"" +
                                            newMail + "\")}";
        try {
            statement = connection.createStatement();
            for (Observer observer : contact.getObservers()) {
                try {
                    observer.wait();
                    if (observer.equals(userInit)) {
                        observer.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            statement.execute(query);
            return contact;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for (Observer observer : contact.getObservers()) {
                observer.notify();
            }
            try {
                statement.clearBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Contact delete(Contact contact) {
        query = "{call removeContactByID(\"" + contact.getId() + "\")}";
        try {
            statement = connection.createStatement();
            for (Observer observer : contact.getObservers()) {
                try {
                    observer.wait();
                    if (observer.equals(userInit)) {
                        observer.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            statement.execute(query);
            return contact;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for (Observer observer : contact.getObservers()) {
                observer.notify();
            }
            try {
                statement.clearBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Contact> getAll() {
        query = "{call getContactList(\"" + userInit.getUser().getName() + "\")}";
        List<Contact> contacts = new ArrayList();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            contacts = mapper.listMap(resultSet);
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
        return contacts;
    }
}
