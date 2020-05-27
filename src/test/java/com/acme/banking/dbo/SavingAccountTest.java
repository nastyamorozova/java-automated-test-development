package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.domain.Client;
import main.java.com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class SavingAccountTest {

    public  UUID stubId;
    public  Client dummyClient;
    @Before
    public void initSettings() {
        stubId = UUID.randomUUID();
        dummyClient = new Client(stubId,"dummy client name",null);

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullIdWhenCreated(){

        SavingAccount sut = new SavingAccount(null, dummyClient.getId(),100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullClientWhenCreated(){

        SavingAccount sut = new SavingAccount(stubId, null,100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowInfiniteAmountWhenCreated(){

        SavingAccount sut = new SavingAccount(stubId, dummyClient.getId(),Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNaNAmountWhenCreated(){

        SavingAccount sut = new SavingAccount(stubId, dummyClient.getId(),Double.NaN);
    }

}


