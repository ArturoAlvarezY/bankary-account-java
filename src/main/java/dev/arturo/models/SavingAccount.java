package dev.arturo.models;

public class SavingAccount extends BankAccount{

    private boolean isActive;

    public SavingAccount(Float balance, Integer consignmentsNumbers, Integer bankWithdrawals,
            Float annualRatePercentage, Float monthlyCommission, boolean isActive) {
        super(balance, consignmentsNumbers, bankWithdrawals, annualRatePercentage, monthlyCommission);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean activeOrInactive(){
        if (isActive == false) {
            this.isActive = false;
        }
        return this.isActive=true;
    }
    
}
