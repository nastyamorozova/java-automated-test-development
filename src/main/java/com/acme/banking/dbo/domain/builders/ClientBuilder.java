package main.java.com.acme.banking.dbo.domain.builders;

import main.java.com.acme.banking.dbo.domain.Client;
import main.java.com.acme.banking.dbo.domain.SavingAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class ClientBuilder {
    private  UUID id;
    private String name;
    private Collection<SavingAccount> accounts = new ArrayList<>();

    public ClientBuilder(){
        id = UUID.randomUUID();

    }

    public ClientBuilder withSavingAccount (SavingAccount savingAccount){
        accounts.add(savingAccount);
        return this;
    }
    public Collection<SavingAccount> savingAccounts (){
        return accounts;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClientBuilder withName(String name) {
        this.name = name;
        return this;
    }

public Client build(){
        return new Client(id,name,new ArrayList<>(accounts));

}
}

