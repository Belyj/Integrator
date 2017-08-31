package ru.handbook.dao.dbdao.mysql.mappers.objectmapperimpl;

import org.apache.log4j.Logger;
import ru.handbook.dao.dbdao.mysql.mappers.ObjectMapper;
import ru.handbook.model.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements ObjectMapper<User> {

    private static final Logger log = Logger.getLogger(UserMapperImpl.class);

    @Override
    public User map(ResultSet resultSet) {
        log.info("Запущен маппинг пользователя");
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
    public List<User> listMap(ResultSet resultSet) {
        log.info("Запущен маппинг листа пользователей");
        return null;
    }

    public List<User> listWithCountsMap(ResultSet resultSet) {
        log.info("Запущен маппинг листа пользователей с счетчиком");
        List<User> users = new ArrayList();
        User user;
        Integer userID;
        String userName;
        Integer count;
        try {
            while (resultSet.next()) {
                userID = resultSet.getInt("user_id");
                userName = resultSet.getString("uname");
                count = resultSet.getInt("count");
                user = new User(userID, userName, count);
                users.add(user);
            }
            return users;
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

    public Float count(ResultSet resultSet) {
        log.info("Запущен маппинг счетчика");
        Float count = null;
        try {
            while (resultSet.next()) {
                count = resultSet.getFloat(1);
            }
            return Float.valueOf(count);
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
