package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.AccountService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Enter customer name");
        customer.setName(scanner.nextLine());
        System.out.println("Enter customer address");
        customer.setAddress(scanner.nextLine());

        System.out.println("savings account creation");
        SavingsAccount savingsAccount = new SavingsAccount();
        System.out.println("Enter savings account interest rate");
        String rawInterestRate = scanner.nextLine();
        savingsAccount.setInterestRate(Double.parseDouble(rawInterestRate));
        System.out.println("Enter savings account balance");
        String rawBalance = scanner.nextLine();
        savingsAccount.setBalance(Double.parseDouble(rawBalance));
        System.out.println("Enter savings account number");
        savingsAccount.setAccountNumber(scanner.nextLine());

        savingsAccount.setCustomer(customer);

        AccountService.computeInterestGain(savingsAccount);

        System.out.println(savingsAccount.getBalance());
        Stock stock = new Stock();
        stock.setPrice(3000.0);
        stock.setName("Apple");

        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setBalance(100000);
        investmentAccount.setAccountNumber("123456789");
        investmentAccount.setCustomer(customer);

        StockOrder order1 = AccountService.buyStock(3, stock, investmentAccount);

        Stock stock2 = new Stock();
        stock2.setPrice(200.0);
        stock2.setName("Microsoft");

        StockOrder order2 = AccountService.buyStock(2, stock2, investmentAccount);


    }



}
