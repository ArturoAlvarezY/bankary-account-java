package dev.arturo.models;

public class BankAccount {
    private Float balance;
    private Integer consignmentsNumbers = 0;
    private Integer bankWithdrawals = 0;
    private Float annualRatePercentage;
    private Float monthlyCommission;

    public BankAccount(Float balance, Integer consignmentsNumbers, Integer bankWithdrawals, Float annualRatePercentage,
            Float monthlyCommission) {
        this.balance = balance;
        this.consignmentsNumbers = 0;
        this.bankWithdrawals = 0;
        this.annualRatePercentage = annualRatePercentage;
        this.monthlyCommission = monthlyCommission;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getConsignmentsNumbers() {
        return consignmentsNumbers;
    }

    public void setConsignmentsNumbers(Integer consignmentsNumbers) {
        this.consignmentsNumbers = consignmentsNumbers;
    }

    public Integer getBankWithdrawals() {
        return bankWithdrawals;
    }

    public void setBankWithdrawals(Integer bankWithdrawals) {
        this.bankWithdrawals = bankWithdrawals;
    }

    public Float getAnnualRatePercentage() {
        return annualRatePercentage;
    }

    public void setAnnualRatePercentage(Float annualRatePercentage) {
        this.annualRatePercentage = annualRatePercentage;
    }

    public Float getMonthlyCommission() {
        return monthlyCommission;
    }

    public void setMonthlyCommission(Float monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }

    ///Methods

    public Float consign(Float consign){
        if (consign > 0) {
            this.balance += consign;
            this.consignmentsNumbers ++;

            return this.balance + this.consignmentsNumbers;
        }
        System.out.println("The consign must be greater than 0");
        return this.balance;
    }

    public Float withdrawCash(Float quantity){

        if (quantity > this.balance) {
        System.out.println("Insufficient Balance");
        return this.balance;
        }
        
        if (quantity > 0) {
        this.balance -= quantity;
        return this.balance;
        }

        if (quantity < 0){
            System.out.println("do you want negative money?");
            return null;
        }

        System.out.println("You have to select a quantity greather than 0");
        return this.balance;
    }

    public Float calcMonthlyInterest() {
        Float monthlyInterest  = (this.annualRatePercentage/12)*this.balance;

        if (this.annualRatePercentage <= 0) {
            monthlyInterest = 0f;
        }

        return monthlyInterest;
    }

    public Float monthlyStatement(){

        Float balanceAfterInterest = calcMonthlyInterest() - this.balance;

        return this.balance = balanceAfterInterest;
    }

    @Override
    public String toString() {
        return "balance" + " " + balance + ", " + "Consignments Numbers" + " " + consignmentsNumbers + ", " + "bankWithdrawals" + " " + bankWithdrawals + ", " + "annualRatePercentage" + " " + annualRatePercentage + " , " + "monthlyCommission" + " " + monthlyCommission;
    }

 
}
