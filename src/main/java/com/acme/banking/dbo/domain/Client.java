package main.java.com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private final UUID id;
    private final String name;
    private Collection<SavingAccount> accounts = new ArrayList<>();

    public Client(UUID id, String name,Collection<SavingAccount> accounts) {
        if (id == null) throw new IllegalArgumentException();
        if (name == null|| "".equals(name)) throw new IllegalArgumentException("Client Name should not be empty");

        this.id = id;
        this.name = name;
        this.accounts = accounts;

    }
 public void addSavingAccount (SavingAccount savingAccount){
       accounts.add(savingAccount);
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
}
