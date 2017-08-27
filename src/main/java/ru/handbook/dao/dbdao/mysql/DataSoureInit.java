package ru.handbook.dao.dbdao.mysql;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSoureInit {

    private Connection connection;

    private DataSource dataSource;

    DataSoureInit() {
        try {
            Context context = new InitialContext();
            Context initCtx = (Context) context.lookup("java:/comp/env");
            dataSource = (DataSource) initCtx.lookup("jdbc/Int");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()){
                connection = dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
