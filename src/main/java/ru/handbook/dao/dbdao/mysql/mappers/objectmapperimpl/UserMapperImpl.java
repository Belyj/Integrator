package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapperImpl implements ObjectMapper<User> {

    @Override
    public User map(ResultSet resultSet) {
        User user;
        String userName = "";
        Integer userID = 0;
        try {
            while (resultSet.next()) {
                userID = resultSet.getInt("uid");
                userName = resultSet.getString("uname");
            }
            user = new User(userName, userID);
            return user;
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
    public List<User> listMap(ResultSet resultSet) {
        return null;
    }
}
