import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; 

import dev.arturo.models.BankAccount;

public class BankAccountTest {

    BankAccount bankAccount = new BankAccount(4.2f, 0, null, null, null);

    @Test
    void testIfConsignIsZeroBalanceKeepsEqual() {
    assertThat(bankAccount.consign(0f), is(4.2f));
    }
    @Test
    void testIfConsignIsZeroConsignmentsNumbersKeepsEqual() {
    bankAccount.consign(0f);
    assertThat(bankAccount.getConsignmentsNumbers(), is(0));
    }

    @Test
    void testIfConsignIsGreaterThanZeroConsignmentsNumbersGonnaIncrement() {

    bankAccount.consign(100f);
    assertThat(bankAccount.getConsignmentsNumbers(), is(1));
    bankAccount.consign(10000f);
    assertThat(bankAccount.getConsignmentsNumbers(), is(2));
    }

    @Test
    void testIfConsignsIsGreaterThanZeroBalanceIncrements() {
    bankAccount.consign(1f);
    assertThat(bankAccount.getBalance(), is(5.2f));
    assertThat(bankAccount.getConsignmentsNumbers(), is(1));
    }

}
