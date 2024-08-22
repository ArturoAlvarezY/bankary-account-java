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
    void testWithDrawCashUpdateTheOverdrafAndTheBalancetWhenTheQuantityIsGreatherThanBalance(){
        currentAccount.withdrawCash(3f);

        assertThat(currentAccount.getOverdraft(), is(1));
        assertThat(currentAccount.getBalance(), is(0f));
    }

    @Test
    void testWithDrawCashIsNullIfTheQuantityParameterIsZero(){
        assertThat(currentAccount.withdrawCash(0f), is(nullValue()));
    }
}
