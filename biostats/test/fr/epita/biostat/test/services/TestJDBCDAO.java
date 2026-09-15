package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.BiostatJdbcDAO;

import java.sql.SQLException;

public class TestJDBCDAO {
    static void main() throws SQLException {
        BiostatJdbcDAO dao = new BiostatJdbcDAO();
        System.out.println(dao.findAll());
        dao.save(new BiostatEntry("Thomas", "M", 25, 175, 65));
        System.out.println(dao.findAll());
        dao.update(new BiostatEntry("Thomas", "M", 26, 175, 65));
        System.out.println(dao.findAll());

        dao.delete(new BiostatEntry("Thomas", null, 0, 0, 0));
        System.out.println(dao.findAll());
    }
}
