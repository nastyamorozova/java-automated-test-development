package main.java.com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import main.java.com.acme.banking.dbo.domain.Cash;

import java.util.Collection;
import java.util.UUID;

public class Processing {
    public UUID createClient(String name) {
        return null;
    }

    public Collection<Account> getAccountsByClientId(UUID clientId) {
        return null;
    }

    public void transfer(double amount, UUID fromAccountId, UUID toAccountId) {
        cash(amount,fromAccountId);
        cash(-amount,toAccountId);
    }

    public void cash(double amount, UUID fromAccountId) {

        Cash.log(amount, fromAccountId);
    }
}
