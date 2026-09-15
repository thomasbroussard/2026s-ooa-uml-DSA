package fr.epita.biostat.test.services;

import fr.epita.biostat.datamodel.BiostatEntry;
import fr.epita.biostat.service.CSVService;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class CSVServiceTest {

    static void main() throws FileNotFoundException {
        List<BiostatEntry> entries =
                CSVService.readCSV("./java-examples/biostats/biostats.csv");
        System.out.println(entries);
        CSVService.writeCSV(entries, "./java-examples/biostats/biostats-output.csv");
        List<BiostatEntry> otherEntries = CSVService.readCSV("./java-examples/biostats/biostats-output.csv");

        if (otherEntries.size() == entries.size()){
            System.out.println("The two lists have same size :" + otherEntries.size());
        }

        otherEntries.sort(Comparator.comparing(BiostatEntry::getName));
        entries.sort(Comparator.comparing(BiostatEntry::getName));

        for (int i = 0; i < entries.size(); i++){
            if (otherEntries.get(i).equals(entries.get(i))){
                System.out.println("The two lists have same entries :" + otherEntries.get(i));
            }else{
                System.out.println("The two lists have different entries for index :" + i + " " + otherEntries.get(i));
            }
        }
    }
}
