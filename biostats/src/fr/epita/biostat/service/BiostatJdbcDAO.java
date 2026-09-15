package fr.epita.biostat.service;

import fr.epita.biostat.datamodel.BiostatEntry;

import java.sql.*;
import java.util.ArrayList;
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

    public void delete(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();
        String deleteQuery = "DELETE FROM BIOSTAT WHERE NAME = ?";
        PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
        pstmt.setString(1, entry.getName());
        pstmt.execute();
        connection.close();
    }

    public void update(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();
        String updateQuery = "UPDATE BIOSTAT SET AGE = ? WHERE NAME = ?";
        PreparedStatement pstmt = connection.prepareStatement(updateQuery);
        pstmt.setInt(1, entry.getAge());
        pstmt.setString(2, entry.getName());
        pstmt.execute();
        connection.close();
    }

    public List<BiostatEntry> findAll() throws SQLException {
        Connection connection = getConnection();
        List<BiostatEntry> entries = new ArrayList<>();
        String selectQuery = "SELECT * FROM BIOSTAT";

        PreparedStatement pstmt = connection.prepareStatement(selectQuery);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            BiostatEntry entry = new BiostatEntry();
            entry.setName(rs.getString("NAME"));
            entry.setAge(rs.getInt("AGE"));
            entry.setGender(rs.getString("GENDER"));
            entry.setHeight(rs.getInt("HEIGHT"));
            entry.setWeight(rs.getInt("WEIGHT"));
            entries.add(entry);
        }
        return entries;

    }

    public List<BiostatEntry> find(BiostatEntry qbe) throws SQLException {
        Connection connection = getConnection();
        List<BiostatEntry> entries = null;
        String selectQuery = """
                SELECT * FROM BIOSTAT 
                WHERE 
                    (? IS NULL OR NAME = ?)
                  AND 
                    GENDER = ?
        """;

        PreparedStatement pstmt = connection.prepareStatement(selectQuery);
        pstmt.setString(1, qbe.getName());
        pstmt.setString(2, qbe.getName());
        pstmt.setString(3, qbe.getGender());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            BiostatEntry entry = new BiostatEntry();
            entry.setName(rs.getString("NAME"));
            entry.setAge(rs.getInt("AGE"));
            entry.setGender(rs.getString("GENDER"));
            entry.setHeight(rs.getInt("HEIGHT"));
            entry.setWeight(rs.getInt("WEIGHT"));
            entries.add(entry);
        }
        return entries;

    }




}
