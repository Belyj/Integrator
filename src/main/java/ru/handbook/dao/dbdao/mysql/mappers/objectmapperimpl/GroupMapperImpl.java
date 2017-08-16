package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements ObjectMapper<Group> {

    String query;
    private Driver driver;
    private Connection connection;
    ResultSet resultSet;
    Statement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    ObjectMapper mapper = new GroupMapperImpl();

    public Connection createConnetction() {
        try {
            System.out.println("Creating driver...");
            driver = new Driver();
            System.out.println("Register Driver..");
            DriverManager.registerDriver(driver);
            System.out.println("Create connection...");
            return connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
        return null;
    }

    private Integer count() {
        query = "{call gorupContactsCount(\"" + "G" + "\", " + "\"RU\"" + ")}";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group map(ResultSet resultSet) {
        Group group;
        List<Contact> contacts;
        int size = count();
        Contact[] c = new Contact[size];
        Contact contact;
//        List<Integer> contactID;
        Array contactID;
//        List<String> contactName;
        Array contactName;
        try {
            //contacts = new ArrayList();
//            contactID = new ArrayList();
//            contactName = new ArrayList();
            while (resultSet.next()) {
                int groupID = resultSet.getInt("group_id");
                String groupName = resultSet.getString("gname");
//                contactID.add(resultSet.getInt("cid"));
//                contactName.add(resultSet.getString("cname"));
                contactID = resultSet.getArray("cid");
                contactName = resultSet.getArray("cname");
                contacts = new ArrayList();
                for (int i = 0; i < size; i++) {
                    contacts.add(new Contact(contactID[i], contactName[i]));
                }
                for (int i = 0; i < size; i++) {

                }


                group = new Group(groupID, groupName, contacts);
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Group> listMap(ResultSet resultSet) {
        List<Group> groups;
        Group group;
        List<Contact> contacts;
        Contact contact;
        try {
            groups = new ArrayList();
            contacts = new ArrayList();
            while (resultSet.next()) {
                int groupID = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int contactID = resultSet.getInt("cid");
                String contactName = resultSet.getString("cname");
                contact = new Contact(contactID, contactName);
                contacts.add(contact);
                group = new Group(groupID, groupName, contacts);
                groups.add(groupID, group);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
