package fr.epita.biostat.launcher;

import fr.epita.biostat.CSVService;
import fr.epita.biostat.datamodel.BiostatEntry;

import java.io.FileNotFoundException;

public class Main {

    static void main(String[] args) throws FileNotFoundException {
        CSVService.readCSV("./java-examples/biostats/biostats.csv");
    }
}
