package dev.arturo;

import dev.arturo.models.CurrentAccount;

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
        CurrentAccount currentAccount = new CurrentAccount(4f, 3, 5, 3f, 5f, 0);
        System.out.println(currentAccount.toString());
    }
}
