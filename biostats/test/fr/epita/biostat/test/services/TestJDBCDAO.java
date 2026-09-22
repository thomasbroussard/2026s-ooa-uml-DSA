package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.BiostatJdbcDAO;

import java.sql.SQLException;
import java.util.List;

public class TestJDBCDAO {
    static void main() throws SQLException {

        //given
        BiostatJdbcDAO dao = new BiostatJdbcDAO();
        System.out.println(dao.findAll());
        dao.save(new BiostatEntry("Thomas", "M", 25, 175, 65));
        System.out.println(dao.findAll());
        dao.update(new BiostatEntry("Thomas", "M", 26, 175, 65));
        System.out.println(dao.findAll());

        //when
        dao.delete(new BiostatEntry("Thomas", null, 0, 0, 0));

        //then

        List<BiostatEntry> list = dao.findAll();
        if (list.isEmpty()){
            System.out.println("List is empty: success");
        }else{
            System.out.println("List is not empty: failure");
            System.out.println(list);
        }
    }
}
