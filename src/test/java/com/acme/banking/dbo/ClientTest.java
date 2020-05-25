package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.domain.Client;
import main.java.com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class ClientTest {
    Collection<Client> testClients;
    Collection<SavingAccount> testAccounts;


    @Before
    public  void initSettings() {


        Client clientVasya = new Client(UUID.randomUUID(), "Vasya");
        Client clientPetya = new Client(UUID.randomUUID(),"Petya");

        SavingAccount vasyaAcc1 = new SavingAccount(UUID.randomUUID(),clientVasya,100);
        SavingAccount vasyaAcc2 = new SavingAccount(UUID.randomUUID(),clientVasya,200);
        SavingAccount petyaAcc1 = new SavingAccount(UUID.randomUUID(),clientPetya,300);
        SavingAccount petyaAcc2 = new SavingAccount(UUID.randomUUID(),clientPetya,400);

        clientVasya.addSavingAccount(vasyaAcc1);
        clientVasya.addSavingAccount(vasyaAcc2);
        clientPetya.addSavingAccount(petyaAcc1);
        clientPetya.addSavingAccount(petyaAcc2);

        testClients = new ArrayList<>();
        testAccounts = new ArrayList<>();

        testClients.add(clientVasya);
        testClients.add(clientPetya);
        testAccounts.add(vasyaAcc1);
        testAccounts.add(vasyaAcc2);
        testAccounts.add(petyaAcc1);
        testAccounts.add(petyaAcc2);

    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }
    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowEmptyNameWhenCreated(){

        UUID stubId = UUID.randomUUID();
        Client sut = new Client(stubId, "");
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullNameWhenCreated(){

        UUID stubId = UUID.randomUUID();
        Client sut = new Client(stubId, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullIdWhenCreated(){

        Client sut = new Client(null, "dummy client name");
    }

    @Test
    public void clientShouldReturnOnlyOwnedAccounts(){

        for(Client client:testClients){
            for(SavingAccount savingAccount:client.savingAccounts()){
                assertEquals(savingAccount.getClient().getId(),client.getId());
            }
        }

    }
    @Test
    public void savingAccountShouldExistForClient(){
        for(SavingAccount savingAccount:testAccounts){

            assertTrue(savingAccount.getClient().savingAccounts().contains(savingAccount));
        }

    }

}
