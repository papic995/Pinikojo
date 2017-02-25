package util;

import java.sql.*;

/**
 * Created by Johnny on 2/18/2017.
 */

public class DbConnection {
    private Connection dbh;
    private static DbConnection dbConnection;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/pinokijoapp";
            String username = "root";
            String password = "";
            this.dbh = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getDbConnection() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public void setAutoCommit(boolean on_off) throws SQLException {
        this.dbh.setAutoCommit(on_off);
    }

    public void commitTransaction() throws SQLException {
        this.dbh.commit();
    }

    public ResultSet selectQuery(String sql) throws SQLException {
        Statement statement = this.dbh.createStatement();
        return statement.executeQuery(sql);
    }
}
