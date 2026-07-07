package fr.epita.bank.fr.epita.bank.services;

import fr.epita.bank.datamodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountService {

    public static StockOrder buyStock(int quantity, Stock stock2, InvestmentAccount investmentAccount) {
        StockOrder stockOrder2 = new StockOrder();
        stockOrder2.setQuantity(quantity);
        stockOrder2.setCurrentPrice(stock2.getPrice());
        stockOrder2.setStock(stock2);
        stockOrder2.setAccount(investmentAccount);
        stockOrder2.setCommission(stockOrder2.getCurrentPrice() * 0.01);
        return stockOrder2;
    }



    public static double computeInterestGain(SavingsAccount savingsAccount) {
        double gain = savingsAccount.getInterestRate() * savingsAccount.getBalance();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
        return gain;
    }

    public static List<Stock> getStockList(String path) {
        List<Stock> stocks = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = getScanner(file);
        if (scanner == null) {
            return stocks;
        }
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String secondLine = scanner.nextLine();
            if (secondLine.isEmpty()) {
                continue;
            }
            String[] parts = secondLine.split(";");
            Stock stock = new Stock();
            stock.setName(parts[0]);
            stock.setPrice(Double.parseDouble(parts[1]));
            stocks.add(stock);
        }

        return stocks;
    }

    private static Scanner getScanner(File file) {
        if (file.exists()) {
            System.out.println("File exists");
        }else {
            System.out.println("File does not exist");
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (Exception e) {
            System.out.println("Error while reading file");
            e.printStackTrace();
        }
        return scanner;
    }

    public static List<Customer> getCustomersList(String path) {
        List<Customer> customers = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            System.out.println("File exists");
        }else {
            System.out.println("File does not exist");
            return customers;
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (Exception e) {
            System.out.println("Error while reading file");
            e.printStackTrace();
        }
       scanner.nextLine();
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

        return customers;
    }
}
