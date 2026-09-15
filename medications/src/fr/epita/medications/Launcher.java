package fr.epita.medications;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    static void main() throws IOException {
        File file = new File("./medications/medications.csv");
        List<String> list = Files.readAllLines(file.toPath());
        List<Medication> medications = new ArrayList<>();
        list.remove(0);
        for (String line : list) {
            String[] parts = line.split(";");
            Medication medication = new Medication();
            medication.setName(parts[1]);
            medication.setDescription(parts[2]);
            medication.setId(Integer.parseInt(parts[0]));
            medications.add(medication);
        }


        PrintWriter printWriter = new PrintWriter("./medications/medications-output.csv");
        for (Medication medication : medications) {
            printWriter.println(medication.getId() +  ";" + medication.getDescription() + ";" + medication.getName());
        }


        printWriter.close();


    }
}
