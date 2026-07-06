package fr.epita.bank.datamodel;

public class StockOrder {
    private int quantity;
    private double currentPrice;
    private double commission;

    InvestmentAccount account;
    Stock stock;

}
