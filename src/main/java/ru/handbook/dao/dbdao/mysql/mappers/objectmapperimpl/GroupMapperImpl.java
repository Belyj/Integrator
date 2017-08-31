package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import org.apache.log4j.Logger;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements ObjectMapper<Group> {

    private static final Logger log = Logger.getLogger(GroupMapperImpl.class);

    public Group mapEasy(ResultSet resultSet) {
        log.info("Запущен маппинг группы без списка контактов");
        Group group;
        try {
            int groupID = 0;
            String groupName = "";
            while (resultSet.next()) {
                groupID = resultSet.getInt("gid");
                groupName = resultSet.getString("gname");
            }
            group = new Group(groupID, groupName);
            return group;
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
    public Group map(ResultSet resultSet) {
        log.info("Запущен маппинг группы");
        Group group;
        Contact contact;
        List<Contact> contacts;
        try {
            int groupID = 0;
            String groupName = "";
            contacts = new ArrayList();
            while (resultSet.next()) {
                groupID = resultSet.getInt("group_id");
                groupName = resultSet.getString("gname");
                int contactID = resultSet.getInt("cid");
                String contactName = resultSet.getString("cname");
                contact = new Contact(contactID, contactName);
                contacts.add(contact);
            }
            group = new Group(groupID, groupName, contacts);
            return group;
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
    public List<Group> listMap(ResultSet resultSet) {
        log.info("Запущен маппинг листа групп");
        List<Group> groups;
        Group group;
        try {
            groups = new ArrayList();
            while (resultSet.next()) {
                int groupID = resultSet.getInt("group_id");
                String groupName = resultSet.getString("gname");
                group = new Group(groupID, groupName);
                groups.add(group);
            }
            return groups;
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

    public List<Group> groupsWithContactsMap(ResultSet resultSet) {
        log.info("Запущен маппинг листа групп без контактов");
        List<Group> groups;
        Group group;
        List<Contact> contacts;
        Contact contact;
        try {
            groups = new ArrayList();
            contacts = new ArrayList();
            while (resultSet.next()) {
                int groupID = resultSet.getInt("group_id");
                String groupName = resultSet.getString("gname");
                group = new Group(groupID, groupName);
                int contactID = resultSet.getInt("cid");
                String contactName = resultSet.getString("cname");
                contact = new Contact(contactID, contactName);
                contacts.add(contact);
                group.setInner(contacts);
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            log.error("SQLException");
            e.printStackTrace();
        }
        return null;
    }
}
