package fr.epita.bank.test;

import fr.epita.bank.datamodel.Customer;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFileIO {

    static void main(String[] args) {
        File file = new File("./customers.csv");

        if (file.exists()) {
            System.out.println("File exists");
        }else {
            System.out.println("File does not exist");
            return;
        }
        Scanner scanner = null;
        try {
           scanner = new Scanner(file);
        }catch (Exception e) {
            System.out.println("Error while reading file");
            e.printStackTrace();
        }
        String line = scanner.nextLine();
        System.out.println(line);

        List<Customer> customers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String secondLine = scanner.nextLine();
            if (secondLine.isEmpty()) {
                continue;
            }
            String[] parts = secondLine.split(";");
            Customer customer = new Customer();
            customer.setName(parts[0]);
            customer.setAddress(parts[1]);
            customers.add(customer);
        }

        System.out.println(customers);




    }
}
