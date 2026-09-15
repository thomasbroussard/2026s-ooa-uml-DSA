package fr.epita.biostat.test.services;

import java.sql.*;

public class JDBCTest {

    static void main() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "test", "test");
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTAT (NAME VARCHAR(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT);");
        preparedStatement.execute();

        String insertQuery = "INSERT INTO BIOSTAT VALUES ('Thomas', 'M', 25, 175, 65);";
        String selectQuery = "SELECT * FROM BIOSTAT;";
        String updateQuery = "UPDATE BIOSTAT SET AGE = 40  WHERE NAME = 'Thomas';";
        String deleteQuery = "DELETE FROM BIOSTAT WHERE NAME = 'Thomas';";

        connection.prepareStatement(insertQuery).execute();
        connection.prepareStatement(updateQuery).execute();


        ResultSet resultSet = connection.prepareStatement(selectQuery).executeQuery();

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString("NAME") + " "
                    + resultSet.getString("GENDER") + " "
                    + resultSet.getInt("AGE") + " "
                    + resultSet.getInt("HEIGHT") + " "
                    + resultSet.getInt("WEIGHT"));
        }

        connection.prepareStatement(deleteQuery).execute();
    }
}
