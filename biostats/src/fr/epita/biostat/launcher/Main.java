package fr.epita.biostat.launcher;

import fr.epita.biostat.CSVService;
import fr.epita.biostat.datamodel.BiostatEntry;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    static void main(String[] args) throws FileNotFoundException {
        List<BiostatEntry> entries =
                CSVService.readCSV("./java-examples/biostats/biostats.csv");
        System.out.println(entries);
    }
}
