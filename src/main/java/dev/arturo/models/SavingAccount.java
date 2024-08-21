package dev.arturo.models;

public class SavingAccount extends BankAccount {

    private boolean isActive;

    public SavingAccount(Float balance, Float annualRatePercentage, Float monthlyCommission, boolean isActive) {
        super(balance, 0, 0, annualRatePercentage, monthlyCommission);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /// METHODS TO DONT CONFUSE ME

    public Boolean accountStatus() {
        if (isActive == false) {
            return false;
        }
        return true;
    }

    public Boolean comprobateFunds() {
        if (!isActive) {
            return null;
        }

        if (getBalance() >= 10000) {
            return this.isActive = true;
        }
        return false;
    }

    @Override

    public Float consign(Float consign) {

        if (!accountStatus() || !comprobateFunds() || consign <= 0) {
            return null;
        }
        Float newBalance = this.getBalance() + consign;
        this.setBalance(newBalance);

        this.setConsignmentsNumbers(getConsignmentsNumbers() + 1);

        return this.getBalance();
    }

    @Override
    public Float withdrawCash(Float quantity) {
        if (!comprobateFunds()) {
            return null;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
            return null;
        }

        Float actualBalance = this.getBalance() - quantity;

        this.setBalance(actualBalance);

        return this.getBalance();
    }

    @Override
    public Float calcMonthlyInterest() {

        Float monthlyInterest = (getAnnualRatePercentage() / 12) * getBalance();

        if (this.getAnnualRatePercentage() <= 0) {
            monthlyInterest = 0f;
        }

        Integer widthments = getConsignmentsNumbers();
        Float balanceAfterMonthlyInterest = getBalance() - monthlyInterest;

        if (widthments > 4) {
            Float newComission = 1000f;
            return balanceAfterMonthlyInterest - newComission;
        }

        if (balanceAfterMonthlyInterest < 10000f) {
            System.out.println("Your account must have more than 10k to be a saving account");
            return null;
        }

        return balanceAfterMonthlyInterest;

    }

}
