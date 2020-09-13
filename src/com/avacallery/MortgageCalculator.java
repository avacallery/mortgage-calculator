package com.avacallery;

public class MortgageCalculator {
    private final static byte MONTHS_PER_YEAR = 12;
    private final static byte PERCENT = 100;

    //encapsulate instance fields
    // the data that we store here represent the state of our calculator object
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        // initialize private fields
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short)(getNumberOfPayments());

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }


    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short) getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );

        return mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    // these two methods are private bc of implementation detail
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_PER_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_PER_YEAR;
    }
}
