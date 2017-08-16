package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
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

public class MySQLGroupDAOImpl implements GroupDAO{

    String query;
    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    Statement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    ObjectMapper mapper = new GroupMapperImpl();

    public MySQLGroupDAOImpl() {
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
    public void deleteFromGroup(Contact contact, Group group) {

    }

    @Override
    public void addInGroup(Contact contact, Group group) {

    }

    @Override
    public Group create(Group group) {
        return null;
    }

    @Override
    public Group getByName(Group group) {
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group delete(Group group) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        query = "{call getGroupList(\"" + "RU" + "\")}";
        List<Group> groups = new ArrayList();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            groups = mapper.listMap(resultSet);
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
        return groups;
    }
}
