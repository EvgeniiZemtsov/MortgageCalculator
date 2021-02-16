package com.company;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MortgageReport {

    private final NumberFormat currencyInstance;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE\n--------------");
        NumberFormat currency = currencyInstance;
        currency.setCurrency(Currency.getInstance(Locale.US));
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        NumberFormat currency = currencyInstance;
        currency.setCurrency(Currency.getInstance(Locale.US));
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("\nMORTGAGE\n-------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
