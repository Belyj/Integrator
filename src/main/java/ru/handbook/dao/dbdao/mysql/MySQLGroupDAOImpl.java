package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl.GroupMapperImpl;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.view.contactview.Observer;

import static ru.handbook.Main.userInit;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySQLGroupDAOImpl implements GroupDAO {

    String query;
    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    Statement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    GroupMapperImpl mapper = new GroupMapperImpl();

    public MySQLGroupDAOImpl() {
        try {
            //System.out.println("Creating driver...");
            driver = new Driver();
            //System.out.println("Register Driver..");
            DriverManager.registerDriver(driver);
            //System.out.println("Create connection...");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }

    @Override
    public void deleteFromGroup(Contact contact, Group group) {
        query = "{call removeFromGroup(\"" + contact.getId() + "\", " +  "\"" + group.getId() + "\", " + "\"" + userInit.getUser().getName() + "\"" +" )}";
        try {
            statement = connection.createStatement();
            statement.execute(query);
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addInGroup(Contact contact, Group group) {
        query = "{call addInGroup(\"" + contact.getId() + "\", " +  "\"" + group.getId() + "\", " + "\"" + userInit.getUser().getName() + "\"" +" )}";
        try {
            statement = connection.createStatement();
            statement.execute(query);
            getByName(group);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Group create(Group group) {
        query = "{call createGroup(\"" + group.getName() + "\")}";
        Group g = new Group();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            g = (Group) mapper.mapEasy(resultSet);
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
        return g;
    }

    @Override
    public Group getByName(Group group) {
        query = "{call getGroupByName(\"" + group.getName() + "\", " + "\"" + userInit.getUser().getName() + "\"" + ")}";
        Group g = new Group();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            g = (Group) mapper.map(resultSet);
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
        return g;
    }

    @Override
    public Group update(Group group) {
        System.out.println("New Group Name");
        Group g = new Group(new Scanner(System.in).nextLine());
        query = "{call updateGroup(\"" + group.getId()+ "\", \"" + g.getName() + "\")}";
        try {
            statement = connection.createStatement();
            for (Observer observer : group.getObservers()) {
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
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for (Observer observer : group.getObservers()) {
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

    @Override
    public Group delete(Group group) {
        query = "{call removeGroupByID(\"" + group.getId() + "\")}";
        try {
            statement = connection.createStatement();
            for (Observer observer : group.getObservers()) {
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
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for (Observer observer : group.getObservers()) {
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

    @Override
    public List<Group> getAll() {
        query = "{call getGroupList(\"" + userInit.getUser().getName() + "\")}";
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
