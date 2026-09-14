package fr.epita.biostat.service;

import fr.epita.biostat.datamodel.BiostatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVService {

    public static final String DELIMITER = ",";

    public static List<BiostatEntry> readCSV(String path) throws FileNotFoundException {
        File file = new File(path);
        List<BiostatEntry> biostatEntries = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File does not exist");
            return biostatEntries;
        }
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //skip the first line, because it is the headers
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(DELIMITER);
            String name = parts[0].replace("\"", "").trim();
            String gender = parts[1].replace("\"", "").trim();
            Integer age = Integer.parseInt(parts[2].trim());
            Integer height = Integer.parseInt(parts[3].trim());
            Integer weight = Integer.parseInt(parts[4].trim());

            BiostatEntry entry = new BiostatEntry();
            entry.setAge(age);
            entry.setGender(gender);
            entry.setHeight(height);
            entry.setName(name);
            entry.setWeight(weight);
            biostatEntries.add(entry);
        }

        return biostatEntries;
    }

    public static void writeCSV(List<BiostatEntry> biostatEntries, String path) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(new File(path));

        printWriter.println("\"Name\"" + DELIMITER +
                "\"Sex\"" + DELIMITER +
                "\"Age\""  + DELIMITER +
                "\"Height\""  + DELIMITER +
                "\"Weight\"");

        for (BiostatEntry entry : biostatEntries) {
            printWriter.println(
                    format(entry.getName()) + DELIMITER +
                            "\"" + entry.getGender() + "\"" + DELIMITER +
                            entry.getAge() + DELIMITER +
                            entry.getHeight() + DELIMITER +
                            entry.getWeight());

        }
        printWriter.flush();
        printWriter.close();

    }

    private static String format(String val) {
        return "\"" + val + "\"";
    }

}
