package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.CSVService;

import java.io.FileNotFoundException;
import java.util.List;

public class CSVServiceTest {

    static void main() throws FileNotFoundException {
        List<BiostatEntry> entries =
                CSVService.readCSV("./java-examples/biostats/biostats.csv");
        System.out.println(entries);
        CSVService.writeCSV(entries, "./java-examples/biostats/biostats-output.csv");


    }
}
