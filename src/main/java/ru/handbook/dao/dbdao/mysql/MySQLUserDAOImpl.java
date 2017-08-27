package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.callquery.CallUserQuery;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.UserMapperImpl;
import ru.handbook.dao.objectsdao.UserDAO;
import ru.handbook.model.objects.User;

import java.sql.*;

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
}