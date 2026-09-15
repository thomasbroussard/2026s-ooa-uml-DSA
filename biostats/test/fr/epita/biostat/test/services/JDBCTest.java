package fr.epita.biostat.test.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {

    static void main() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "test", "test");
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTAT (NAME VARCHAR(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT);");
        preparedStatement.execute();

        String insertQuery = "INSERT INTO BIOSTAT VALUES ('Thomas', 'M', 25, 175, 65);";
        String selectQuery = "SELECT * FROM BIOSTAT;";
        String updateQuery = "UPDATE BIOSTAT SET NAME = ? WHERE ID = ?;";
        String deleteQuery = "DELETE FROM BIOSTAT;";

        connection.prepareStatement(insertQuery).execute();




    }
}
