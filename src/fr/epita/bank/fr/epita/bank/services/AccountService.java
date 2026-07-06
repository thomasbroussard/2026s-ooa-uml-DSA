package fr.epita.bank.fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

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
}
