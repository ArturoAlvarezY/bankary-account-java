package dev.arturo.models;

public class CurrentAccount extends BankAccount {

    private Integer overdraft = 0;

    public CurrentAccount(Float balance, Integer consignmentsNumbers, Integer bankWithdrawals,
            Float annualRatePercentage, Float monthlyCommission, Integer overdraft) {
        super(balance, consignmentsNumbers, bankWithdrawals, annualRatePercentage, monthlyCommission);
        this.overdraft = 0;
    }

    public Integer getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }

    @Override 
    public Float withdrawCash(Float quantity){
        
        if (quantity == 0f) {
            System.out.println("Your parameter most be greater than 0");
            return null;
        }

        float calcWithdraw = getBalance() - quantity;

        
        if (calcWithdraw < 0) {
            System.out.println(" you have an overdraft of: ");
            Float overdraftFloat = (this.overdraft).floatValue();
            Float newOverdraft = (overdraftFloat + calcWithdraw) * -1f;
            setOverdraft(newOverdraft.intValue());

            setBalance(0f);
            System.out.println(newOverdraft);
            return newOverdraft;
        }

        setBalance(calcWithdraw);
        return calcWithdraw;
    }

  

}
