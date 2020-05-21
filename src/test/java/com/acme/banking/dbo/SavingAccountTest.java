package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.domain.Client;
import main.java.com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

public class SavingAccountTest {
    public static UUID stubId;
    public static Client dummyClient;
    @BeforeClass
    public static void initSettings() {
        stubId = UUID.randomUUID();
        dummyClient = new Client(stubId,"dummy client name");

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullIdWhenCreated(){
        //region given
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(null, dummyClient,100);
        //endregion

        //region then
        //endregion
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullClientWhenCreated(){
        //region given
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(stubId, null,100);
        //endregion

        //region then
        //endregion
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowInfiniteAmountWhenCreated(){
        //region given
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(stubId, dummyClient,Double.POSITIVE_INFINITY);
        //endregion

        //region then
        //endregion
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNaNAmountWhenCreated(){
        //region given
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(stubId, dummyClient,Double.NaN);
        //endregion

        //region then
        //endregion
    }
}
