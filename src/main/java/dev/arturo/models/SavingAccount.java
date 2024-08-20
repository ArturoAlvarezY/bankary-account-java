package dev.arturo.models;

public class SavingAccount extends BankAccount{
    
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

    public Boolean accountStatus() {
        if (isActive == false) {
            return false;
        }
        return true;
    }

    public Boolean comprobateFunds(BankAccount bankAccount){
        if (!isActive) {
            return null;
        }

        if (getBalance() >= 10000) {
        return this.isActive = true;           
        }
        return false;
    }
}
