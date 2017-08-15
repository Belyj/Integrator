package ru.handbook.dao.dbdao.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.List;

public class MySQLContactDAOImpl implements ObjectDAO<Contact> {

    Driver driver;
    Connection connection;
    CallableStatement statement;
    private String USERNAME = "root";
    private String PASS = "";
    private String URL = "jdbc:mysql://localhost:3306/handbook_schema";
    String query;

    public MySQLContactDAOImpl() {
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
    public Contact create(Contact contact) {
        return null;
    }

    @Override
    public Contact getByName(Contact contact) {
        query = "{call getContactByName(" + contact.getName() + ", " + "RU" + ")}";
        try {
//            statement.setString("contactName", contact.getName());
//            statement.setString("userName", "RU");
            //statement = connection.prepareCall(query);
            File file = new File("D:\\Работы\\Git\\Integrator\\src\\main\\resources\\sqlScripts\\Procedures\\ContactProcedure\\getContactByName.sql");
            FileInputStream fis = null;
            try {
                 fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String query = fis.toString();
            System.out.println(fis.toString());
            ResultSet resultSet =  statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("contact_id");
                String name = resultSet.getString("contactName");
                int phone = resultSet.getInt("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                Contact c = new Contact(name, id, phone, skype, mail);
                System.out.println(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }
}
