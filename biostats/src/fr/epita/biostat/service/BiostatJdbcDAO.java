package fr.epita.biostat.service;

import fr.epita.biostat.datamodel.BiostatEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BiostatJdbcDAO {


    public BiostatJdbcDAO() throws SQLException {

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTAT (NAME VARCHAR(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT);");
        preparedStatement.execute();
        connection.close();
    }

    public void save(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();
        String insertQuery = "INSERT INTO BIOSTAT VALUES (?, ?,?, ?, ?);";
        PreparedStatement pstmt = connection.prepareStatement(insertQuery);
        pstmt.setString(1, entry.getName());
        pstmt.setString(2, entry.getGender());
        pstmt.setInt(3, entry.getAge());
        pstmt.setInt(4, entry.getHeight());
        pstmt.setInt(5, entry.getWeight());
        pstmt.execute();
        connection.close();
    }

    private static Connection getConnection() throws SQLException {
        // FIXME: delegate to a configuration file
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "test", "test");
        return connection;
    }

    public void delete(BiostatEntry entry) throws SQLException{
       Connection connection =  getConnection();
       String deleteQuery = "DELETE FROM BIOSTAT WHERE NAME = ?";
       PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
       pstmt.execute();
       connection.close();
    }

    public void update(BiostatEntry entry) {

    }

    public List<BiostatEntry> findAll() {
        return null;
    }
}
