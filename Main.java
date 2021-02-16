package com.company;

public class Main {

    public static void main(String[] args) {
        // Reading data from the console
        int principal = (int) Console.readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest rate: ", 0, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        //Creating an object responsible for calculation
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        //Creating an object responsible for report
        MortgageReport report = new MortgageReport(calculator);

        //Printing report
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
