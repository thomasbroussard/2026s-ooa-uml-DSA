package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.BiostatJdbcDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestJDBCDAOFind {
    static void main() throws SQLException {

        //given
        BiostatJdbcDAO dao = new BiostatJdbcDAO();
        System.out.println(dao.findAll());
        dao.save(new BiostatEntry("Thomas", "M", 25, 175, 65));

        //when
        List<BiostatEntry> bioList = dao.find(new BiostatEntry("Thomas", null, 0, 0, 0));

        //then

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "test", "test");
        ResultSet resultSet = connection.prepareStatement("SELECT count(*) from BIOSTAT").executeQuery();

    }
}
