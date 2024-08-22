package dev.arturo;

import dev.arturo.models.BankAccount;
import dev.arturo.models.CurrentAccount;
import dev.arturo.models.SavingAccount;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(4f, 3, 5, 3f, 4f);
        System.out.println(bankAccount.toString());
        SavingAccount savingAccount = new SavingAccount(4f, 20f, 3f, true);
        System.out.println(savingAccount.toString());
        CurrentAccount currentAccount = new CurrentAccount(4f, 3, 5, 3f, 5f, 0);
        System.out.println(currentAccount.toString());

    }
}
