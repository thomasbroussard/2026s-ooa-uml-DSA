package fr.epita.biostat;

import fr.epita.biostat.datamodel.BiostatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVService {

    public static List<BiostatEntry> readCSV(String path) throws FileNotFoundException {
        File file = new File(path);
        List<BiostatEntry> biostatEntries = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File does not exist");
            return biostatEntries;
        }
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        return biostatEntries;


    }
}
