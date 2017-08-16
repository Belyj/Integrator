package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements ObjectMapper<Group> {

    @Override
    public Group map(ResultSet resultSet) {
        return null;
    }

    @Override
    public List<Group> listMap(ResultSet resultSet) {
        List<Group> groups;
        Group group;
        try {
            groups = new ArrayList();
            while (resultSet.next()) {
                String name = resultSet.getString("group_name");
                group = new Group(name);
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
}
