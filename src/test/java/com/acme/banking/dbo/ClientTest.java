package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.domain.Client;
import main.java.com.acme.banking.dbo.domain.SavingAccount;
import main.java.com.acme.banking.dbo.domain.builders.ClientBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class ClientTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

  private Map<UUID,Client> testClients;
  private Map<UUID, SavingAccount> testAccounts;


    @Before
    public  void initSettings() {
        ClientBuilder vasyaBuilder = new ClientBuilder();
        ClientBuilder petyaBuilder = new ClientBuilder();

//        Client clientVasya = new Client(UUID.randomUUID(), "Vasya");
//        Client clientPetya = new Client(UUID.randomUUID(),"Petya");

        SavingAccount vasyaAcc1 = new SavingAccount(UUID.randomUUID(),vasyaBuilder.getId(),100);
        SavingAccount vasyaAcc2 = new SavingAccount(UUID.randomUUID(),vasyaBuilder.getId(),200);
        SavingAccount petyaAcc1 = new SavingAccount(UUID.randomUUID(),petyaBuilder.getId(),300);
        SavingAccount petyaAcc2 = new SavingAccount(UUID.randomUUID(),petyaBuilder.getId(),400);

        Client clientVasya = vasyaBuilder.withName("Vasya")
                .withSavingAccount(vasyaAcc1)
                .withSavingAccount(vasyaAcc2).build();
        Client clientPetya = vasyaBuilder.withName("Petya")
                .withSavingAccount(petyaAcc1)
                .withSavingAccount(petyaAcc2).build();
//        clientVasya.addSavingAccount(vasyaAcc1);
//        clientVasya.addSavingAccount(vasyaAcc2);
//        clientPetya.addSavingAccount(petyaAcc1);
//        clientPetya.addSavingAccount(petyaAcc2);


        testClients = new HashMap<>();
        testAccounts = new HashMap<>();

        testClients.put(clientPetya.getId(), clientVasya);
        testClients.put(clientPetya.getId(), clientPetya);
        testAccounts.put(vasyaAcc1.getId(), vasyaAcc1);
        testAccounts.put(vasyaAcc2.getId(), vasyaAcc2);
        testAccounts.put(petyaAcc1.getId(), petyaAcc1);
        testAccounts.put(petyaAcc2.getId(), petyaAcc2);

    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name",null);
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }
    @Test
    public void shouldNotAllowEmptyNameWhenCreated(){

exception.expect(IllegalArgumentException.class);
exception.expectMessage("Client Name should not be empty");

        UUID stubId = UUID.randomUUID();
        Client sut = new Client(stubId, "",null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullNameWhenCreated(){

        UUID stubId = UUID.randomUUID();
        Client sut = new Client(stubId, null,null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullIdWhenCreated(){

        Client sut = new Client(null, "dummy client name",null);
    }

    @Test
    public void clientShouldReturnOnlyOwnedAccounts(){

        for(Client client:testClients.values()) {
            assertThat(client.savingAccounts()).extracting(SavingAccount::getClientId).contains(client.getId());
        }
/*
        for(Client client:testClients){
            for(SavingAccount savingAccount:client.savingAccounts()){
                assertEquals(savingAccount.getClient().getId(),client.getId());
            }
        }
*/

    }
   @Ignore
    @Test
    public void savingAccountShouldExistForClient(){
        for(SavingAccount savingAccount:testAccounts.values()){
            assertTrue(testClients.get(savingAccount.getClient()).savingAccounts().contains(savingAccount));
        }

    }

}
