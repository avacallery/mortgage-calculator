package com.avacallery;

public class MortgageCalculator {
    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ) {

        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_PER_YEAR;
        short numberOfPayments = (short)(years * Main.MONTHS_PER_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_PER_YEAR;
        short numberOfPayments = (short)(years * Main.MONTHS_PER_YEAR);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );

        return mortgage;
    }
}
