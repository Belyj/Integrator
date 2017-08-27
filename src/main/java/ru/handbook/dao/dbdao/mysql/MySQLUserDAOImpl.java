package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.callquery.CallUserQuery;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.UserMapperImpl;
import ru.handbook.dao.objectsdao.UserDAO;
import ru.handbook.model.objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAOImpl extends DataSoureInit implements UserDAO {

    private static volatile MySQLUserDAOImpl instance;
    String query;
    ResultSet resultSet;
    DBProperties dbProperties = new DBProperties();
    UserMapperImpl mapper = new UserMapperImpl();
    CallUserQuery call = new CallUserQuery();
    private Driver driver;

    public MySQLUserDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    public static MySQLUserDAOImpl getInstance() {
        if (instance == null) {
            synchronized (MySQLUserDAOImpl.class) {
                if (instance == null) {
                    instance = new MySQLUserDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public User getByParams(String login, String password) {
        query = call.getUserByName(login, password);
        User u = new User();
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            u = (User) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public Float avgContactsInGroups() {
        query = call.avgContactsInGroups();
        Float count;
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            count = (Float) mapper.count(resultSet);
            resultSet.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Float avgCountOfContacts() {
        query = call.avgCountOfContacts();
        Float count;
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            count = (Float) mapper.count(resultSet);
            resultSet.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> unactiveList() {
        query = call.unactiveList();
        List<User> users = new ArrayList();
        try(Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            users = (List<User>) mapper.listWithCountsMap(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> userContactsCount() {
        query = call.userContactsCount();
        List<User> users;
        try(Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            users = (List<User>) mapper.listWithCountsMap(resultSet);
            resultSet.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Float userCount() {
        query = call.userCount();
        Float count;
        try(Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            count = (Float) mapper.count(resultSet);
            resultSet.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> userGroupsCount() {
        query = call.userGroupsCount();
        List<User> users = new ArrayList();
        try(Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
            users = (List<User>) mapper.listWithCountsMap(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}