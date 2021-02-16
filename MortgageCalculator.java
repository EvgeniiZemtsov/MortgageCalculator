package com.company;

public class MortgageCalculator {
    private static final byte MONTH_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances [month - 1] = calculateBalance(month);
        }
        return balances;
    }

    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments)))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / MONTH_IN_YEAR / PERCENT;
    }

    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }

}
