import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

import dev.arturo.models.SavingAccount;

public class SavingAccountTest {

    SavingAccount savingAccount = new SavingAccount(10000f, 1f, null, true);

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

        assertThat(savingAccount.comprobateFunds(), is(false));
    }

    @Test
    void testIfIsActiveMethodIsFalseComprobateFundsIsNull() {
        savingAccount.setActive(false);

        savingAccount.setBalance(10000000f);

        assertThat(savingAccount.comprobateFunds(), is(nullValue()));
    }

    @Test
    void testConsignMethod(){
        savingAccount.consign(1f);

        assertThat(savingAccount.getBalance(), is(10001f));
        assertThat(savingAccount.getConsignmentsNumbers(), is(1));
    }

    @Test
    void testIfAccountStatusIsFalseReturnNull(){
        savingAccount.setActive(false);

        assertThat(savingAccount.consign(10000000f), is(nullValue()));
    }
    @Test
    void testIfComprobateFoundsIsFalseReturnNull(){
        savingAccount.setBalance(100f);

        assertThat(savingAccount.consign(10000000f), is(nullValue()));
    }

    @Test
    void testIfConsignParameterIs0ReturnNull(){
        savingAccount.setBalance(100f);

        assertThat(savingAccount.consign(0f), is(nullValue()));
    }

    @Test
    void testWithDrawCashIsNullIfComprobateFundsIsNull(){
        savingAccount.setBalance(100f);

        assertThat(savingAccount.withdrawCash(10000000f), is(nullValue()));

    }
    
    @Test
    void testWithDrawCashIsNullIfParameterIsEqualOrMinorThanZero(){

        assertThat(savingAccount.withdrawCash(0F), is(nullValue()));
        assertThat(savingAccount.withdrawCash(-1F), is(nullValue()));

    }

    @Test
    void testWithDrawCash(){
        assertThat(savingAccount.withdrawCash(5000f), is(5000f));
    }

    @Test
    void testCalcMonthlyInterestIsNullIfBalanceAfterMonthlyInterestIsMinnorThan10Thousand(){
        assertThat(savingAccount.calcMonthlyInterest(), is(nullValue()));
    }
    @Test
    void testCalcMonthlyInterestAddsOneThousandOfComisionIfConsignmentsNumbersIsGreatherThanFour(){
        savingAccount.setConsignmentsNumbers(5);
        savingAccount.setBalance(11000f);
        assertThat(savingAccount.calcMonthlyInterest(), is(9083.333f));
    }

    @Test 
    void testCalcMonthlyInterest(){
        savingAccount.setBalance(11000f);
        assertThat(savingAccount.calcMonthlyInterest(), is(10083.333f));
    }

}
