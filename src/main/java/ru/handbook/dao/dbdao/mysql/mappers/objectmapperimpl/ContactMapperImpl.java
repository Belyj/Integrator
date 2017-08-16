package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactMapperImpl implements ObjectMapper<Contact> {

    @Override
    public Contact map(ResultSet resultSet) {
        Contact contact;
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("contact_name");
                int phone = resultSet.getInt("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                contact = new Contact(name, phone, skype, mail);
                return contact;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Contact> listMap(ResultSet resultSet) {
        List<Contact> contacs;
        Contact contact;
        try {
            contacs = new ArrayList();
            while (resultSet.next()) {
                String name = resultSet.getString("contact_name");
                int phone = resultSet.getInt("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                contact = new Contact(name, phone, skype, mail);
                contacs.add(contact);
            }
            return contacs;
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
