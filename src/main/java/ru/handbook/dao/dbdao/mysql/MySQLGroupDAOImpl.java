package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.callquery.CallGroupQuery;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.GroupMapperImpl;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySQLGroupDAOImpl implements GroupDAO {

    private static volatile MySQLGroupDAOImpl instance;
    String query;
    ResultSet resultSet;
    DBProperties dbProperties = new DBProperties();
    GroupMapperImpl mapper = new GroupMapperImpl();
    CallGroupQuery call = new CallGroupQuery();
    private Driver driver;

    public MySQLGroupDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static MySQLGroupDAOImpl getInstance() {
        if (instance == null) {
            synchronized (MySQLGroupDAOImpl.class) {
                if (instance == null) {
                    instance = new MySQLGroupDAOImpl();
                }
            }
        }
        return instance;
    }

    public synchronized void deleteFromGroup(Contact contact, Group group) {
        query = call.deleteFromGroup(contact, group);
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void addInGroup(Contact contact, Group group) {
        query = call.addInGroup(contact, group);
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            getByName(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Group create(Group group) {
        query = call.createGroup(group);
        Group g = new Group();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            g = (Group) mapper.mapEasy(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    public Group getByName(Group group) {
        query = call.getByName(group);
        Group g = new Group();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            g = (Group) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    public synchronized Group update(Group group) {
        System.out.println("New Group Name");
        String newName = new Scanner(System.in).nextLine();
        query = call.update(group, newName);
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Group delete(Group group) {
        query = call.delete(group);
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Group> getAll() {
        query = call.getAll();
        List<Group> groups = new ArrayList();
        try (Connection connection = (Connection) DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            groups = mapper.listMap(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
}