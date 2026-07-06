package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.fr.epita.bank.services.AccountService;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.setName("John");
        customer.setAddress("123 avenue des champs élysées,  Paris, France");

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setInterestRate(0.03);
        savingsAccount.setBalance(30000);
        savingsAccount.setAccountNumber("123456789");

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
