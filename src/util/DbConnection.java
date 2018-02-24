package util;

import org.sqlite.core.DB;

import java.io.File;
import java.sql.*;

/**
 * Created by Johnny on 2/18/2017.
 */

public class DbConnection {
    private Connection dbh;
    private static DbConnection dbConnection;
    private static final String DbLocation = new File("database\\pinokijoDB").getAbsolutePath();

    public DbConnection() {
        try {
            String url = "jdbc:sqlite:" + DbLocation;
            this.dbh = DriverManager.getConnection(url);
        } catch (Exception e) {
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

    public ResultSet prepareStatementQuery (String query, int value) throws SQLException{
        PreparedStatement preparedStatement = this.dbh.prepareStatement(query);
        preparedStatement.setInt(1,value);
        return preparedStatement.executeQuery();
    }
}
