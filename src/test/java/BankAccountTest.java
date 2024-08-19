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

    @Test
    void testIfWithdrawCashQuantityIsZeroBalanceKeepsEquals(){
    bankAccount.withdrawCash(0f);
    assertThat(bankAccount.getBalance(), is(4.2f));
    }

    @Test
    void testIfWithdrawCashQuantityIsGreaterThanBalanceItKeepsEquals(){
    bankAccount.withdrawCash(5.2f);
    assertThat(bankAccount.getBalance(), is(4.2f));
    }

    @Test
    void testIfWithdrawCashQuantityIsEqualThanBalanceIsGonnaBeZero(){
    bankAccount.withdrawCash(4.2f);
    assertThat(bankAccount.getBalance(), is(0f));
    }

    @Test
    void testIfWithdrawCashQuantityIsGreaterThanZeroAndMinnorThanBalanceIsGonnaSubstractThisLast(){
    bankAccount.withdrawCash(1.19f);
    assertThat(bankAccount.getBalance(), is(3.0099998F));
    }

    @Test
    void testIfWithdrawCashQuantityIsnegative(){
    bankAccount.withdrawCash(-1F);
    assertThat(bankAccount.withdrawCash(-1F), is(nullValue()));
}



}
