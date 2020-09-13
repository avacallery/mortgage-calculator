package com.avacallery;

import java.text.NumberFormat;

public class MortgageReport {
    // this class delegates all the responsibility of calculations
    // it should only be responsible for presentation
    private MortgageCalculator calculator;

    // constructor initializes the calculator field
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------");
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_PER_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("-----------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
