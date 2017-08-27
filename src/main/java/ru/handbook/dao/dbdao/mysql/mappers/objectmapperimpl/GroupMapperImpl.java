package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements ObjectMapper<Group> {

    public Group mapEasy(ResultSet resultSet) {
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
    public Group map(ResultSet resultSet) {
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

    public List<Group> groupsWithContactsMap(ResultSet resultSet) {
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
            e.printStackTrace();
        }
        return null;
    }
}
