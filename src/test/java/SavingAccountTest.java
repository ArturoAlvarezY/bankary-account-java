import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

import dev.arturo.models.SavingAccount;

public class SavingAccountTest {

    SavingAccount savingAccount = new SavingAccount(10000f, null, null, true);

    @Test
    void testAccountStatus() {
        assertThat(savingAccount.accountStatus(), is(true));
    }

    @Test
    void testIfIsActiveBooleanIsFalse(){
        savingAccount.setActive(false);

        assertThat(savingAccount.accountStatus(), is(false));
    }

    @Test
    void testIfBalanceIsMinnorThanTenThousandComprobateFundsIsFalse() {
        savingAccount.setBalance(9999F);

        assertThat(savingAccount.comprobateFunds(savingAccount), is(false));
    }

    @Test
    void testIfIsActiveMethodIsFalseComprobateFundsIsNull() {
        savingAccount.setActive(false);

        savingAccount.setBalance(10000000f);

        assertThat(savingAccount.comprobateFunds(savingAccount), is(nullValue()));
    }


}
