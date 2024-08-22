package dev.arturo.models;

public class CurrentAccount extends BankAccount {

    private Integer overdraft = 0;

    public CurrentAccount(Float balance, Integer consignmentsNumbers, Integer bankWithdrawals,
            Float annualRatePercentage, Float monthlyCommission, Integer overdraft) {
        super(balance, consignmentsNumbers, bankWithdrawals, annualRatePercentage, monthlyCommission);
        this.overdraft = overdraft;
    }

    public Integer getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public Float withdrawCash(Float quantity) {

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

    @Override
    public Float consign(Float consign) {

        if (consign > 0) {
            
            if (overdraft > 0) {
                System.out.println("You have overdraft, we have to do an adjustment");
                Float turnOverdraftInFloat = getOverdraft().floatValue();
                Float accountAdjustment = turnOverdraftInFloat - consign;                
                
                if (accountAdjustment < 0) {
                    System.out.println("We did an adjustment and your overdraft is clear, we are gonna put the rest of the money in your balance");
                    setOverdraft(0);
                    setBalance(getBalance() + (accountAdjustment * -1f));
                    setConsignmentsNumbers(getConsignmentsNumbers() +1);
                    return getBalance();
                }

                setOverdraft(accountAdjustment.intValue());
                return accountAdjustment;
            }

            System.out.println("Your new Balance is: ");
            setBalance(consign);
            setConsignmentsNumbers(overdraft + 1);
            return getOverdraft().floatValue();    
        }
    System.out.println("Your consign must be greather than 0");
    return null;
    
    }

    public static void main(String[] args) {

        CurrentAccount currentAccount = new CurrentAccount(10f, null, null, null, null, 3);

        System.out.println(currentAccount.consign(4f));
        System.out.println(currentAccount.getOverdraft());
    
    }

}
