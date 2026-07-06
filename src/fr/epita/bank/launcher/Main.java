package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

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

        double gain = savingsAccount.getInterestRate() * savingsAccount.getBalance();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);

        System.out.println(savingsAccount.getBalance());






    }
}
