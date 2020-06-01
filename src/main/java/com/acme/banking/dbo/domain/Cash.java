package main.java.com.acme.banking.dbo.domain;

import java.util.UUID;

public class Cash {
    public static void log(double amount, UUID fromAccountId) {
        if(amount<0)
    System.out.println("Withdrawn: "+amount+" From Account  "+fromAccountId);
        else
            System.out.println(("Deposit: "+amount+"To Account "+fromAccountId));
    }
}
