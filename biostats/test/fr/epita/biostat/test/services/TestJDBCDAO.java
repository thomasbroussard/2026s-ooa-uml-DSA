package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.BiostatJdbcDAO;

import java.sql.SQLException;

public class TestJDBCDAO {
    static void main() throws SQLException {
        BiostatJdbcDAO dao = new BiostatJdbcDAO();
        dao.save(new BiostatEntry("Thomas", "M", 25, 175, 65));
    }
}
