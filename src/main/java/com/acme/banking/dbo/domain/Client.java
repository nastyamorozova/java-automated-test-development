package main.java.com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private Collection<SavingAccount> accountIds = new ArrayList<>(); //TODO

    public Client(UUID id, String name) {
        if (id == null) throw new IllegalArgumentException();
        if (name == null|| "".equals(name)) throw new IllegalArgumentException("Client Name should not be empty");

        this.id = id;
        this.name = name;
    }
 public void addSavingAccount (SavingAccount savingAccount){
       accountIds.add(savingAccount);
    }
    public Collection<SavingAccount> savingAccounts (){
        return accountIds;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
