package fr.epita.biostat.service;

import fr.epita.biostat.datamodel.BiostatEntry;

import java.sql.PreparedStatement;
import java.util.List;

public class BiostatJdbcDAO {


    public BiostatJdbcDAO(){
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTAT (NAME VARCHAR(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT);");
        preparedStatement.execute();
    }

    public void save(BiostatEntry entry) {

    }

    public void delete(BiostatEntry entry) {

    }

    public void update(BiostatEntry entry) {

    }

    public List<BiostatEntry> findAll() {
        return null;
    }
}
