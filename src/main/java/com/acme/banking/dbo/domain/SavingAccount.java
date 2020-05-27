package main.java.com.acme.banking.dbo.domain;

import java.util.UUID;

public class SavingAccount implements com.acme.banking.dbo.domain.Account {
    private UUID id;
    private UUID client;
    private double amount;

    public SavingAccount(UUID id, UUID client, double amount) {
        if(id == null) throw new IllegalArgumentException();
        if(client == null) throw new IllegalArgumentException();
        if (Double.isInfinite(amount) || Double.isNaN(amount)) throw new IllegalArgumentException();
        this.id = id;
        this.client = client;
        this.amount = amount;
    }

    public UUID getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getClientId() {
        return client;
    }
}
