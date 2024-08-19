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

 


  
}
