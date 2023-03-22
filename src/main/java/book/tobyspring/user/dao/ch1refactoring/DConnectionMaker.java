package book.tobyspring.user.dao.ch1refactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{

    public Connection makeConnection() throws SQLException {
        Connection c = DriverManager.getConnection("", "", "");
        return c;
    }
}
