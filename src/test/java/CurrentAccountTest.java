import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

import dev.arturo.models.CurrentAccount;

public class CurrentAccountTest {

    CurrentAccount currentAccount = new CurrentAccount(2f, 0, null, null, null, null);

    @Test
    void testWithDrawCashUpdateTheBalanceWhenTheQuantityParemeterIsNotGreatherThanTheBalance() {
        currentAccount.withdrawCash(1f);

        assertThat(currentAccount.getBalance(), is(1f));
    }

    @Test
    void testWithDrawCashUpdateTheOverdrafAndTheBalancetWhenTheQuantityIsGreatherThanTheBalance(){

        currentAccount.setBalance(2f);
        currentAccount.withdrawCash(3f);

        assertThat(currentAccount.getOverdraft(), is(1));
    }

    @Test
    void testWithDrawCashIsNullIfTheQuantityParameterIsZero(){
        assertThat(currentAccount.withdrawCash(0f), is(nullValue()));
    }

    @Test
    void testOverdraftExtractMoneyOfTheConsign(){
        currentAccount.setOverdraft(5);

        assertThat(currentAccount.consign(4f), is(1f));
        assertThat(currentAccount.getOverdraft(), is(1));
    }

    @Test
    void testIfConsignParameterIsGreaterThanTheOverdraftTheRestantAmountIsGonnaBeAdditionatedToTheBalance(){
        currentAccount.setOverdraft(5);
        currentAccount.setBalance(0f);

        currentAccount.consign(10f);

        assertThat(currentAccount.getBalance(), is(5f));
    }

    @Test
    void testIfConsignParameterIsEqualThanZeroReturnNull(){
        assertThat(currentAccount.consign(0f), is(nullValue()));
    }

    @Test
    void testIfConsignIsGreatherThanZeroAndOverdriftIsEqualThanZeroSumTheConsignToTheBalance(){
        currentAccount.setBalance(10f);
        currentAccount.setOverdraft(0);
        currentAccount.consign(10f);

        assertThat(currentAccount.getBalance(), is(20f));
    }
}
