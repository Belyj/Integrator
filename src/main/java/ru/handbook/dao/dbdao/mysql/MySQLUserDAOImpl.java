package ru.handbook.dao.dbdao.mysql;

import ru.handbook.dao.dbdao.mysql.callquery.CallUserQuery;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.UserMapperImpl;
import ru.handbook.dao.objectsdao.UserDAO;
import ru.handbook.model.objects.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class MySQLUserDAOImpl implements UserDAO {

    String query;
    private Driver driver;
    ResultSet resultSet;
    DBProperties dbProperties = new DBProperties();
    UserMapperImpl mapper = new UserMapperImpl();
    CallUserQuery call = new CallUserQuery();
    private static volatile MySQLUserDAOImpl instance;

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

    public MySQLUserDAOImpl() {
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    @Override
    public User getByParams(String login, String password) {
        query = call.getUserByName(login, password);
        User u = new User();
        try (Connection connection = DriverManager.getConnection(dbProperties.URL, dbProperties.USERNAME, dbProperties.PASS);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            u = (User) mapper.map(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}