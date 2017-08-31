package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import org.apache.log4j.Logger;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactMapperImpl implements ObjectMapper<Contact> {

    private static final Logger log = Logger.getLogger(ContactMapperImpl.class);

    @Override
    public Contact map(ResultSet resultSet) {
        Contact contact;
        log.info("Запущен маппинг контакта");
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("cid");
                String name = resultSet.getString("cname");
                String phone = resultSet.getString("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                contact = new Contact(id, name, phone, skype, mail);
                return contact;
            }
        } catch (SQLException e) {
            log.error("SQLException");
            e.printStackTrace();
        } finally {
            try {
                log.info("Закрытие Resultseta");
                resultSet.close();
            } catch (SQLException e) {
                log.error("SQLException");
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Contact> listMap(ResultSet resultSet) {
        log.info("Запущен маппинг листа контактов");
        List<Contact> contacs;
        Contact contact;
        try {
            contacs = new ArrayList();
            while (resultSet.next()) {
                int id = resultSet.getInt("cid");
                String name = resultSet.getString("cname");
                String phone = resultSet.getString("phone");
                String skype = resultSet.getString("skype");
                String mail = resultSet.getString("mail");
                contact = new Contact(id, name, phone, skype, mail);
                contacs.add(contact);
            }
            return contacs;
        } catch (SQLException e) {
            log.error("SQLException");
            e.printStackTrace();
        } finally {
            try {
                log.info("Закрытие Resultseta");
                resultSet.close();
            } catch (SQLException e) {
                log.error("SQLException");
                e.printStackTrace();
            }
        }
        return null;
    }
}
