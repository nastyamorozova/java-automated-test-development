package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.service.Processing;
import main.java.com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProcessingTest {

    @Test
    public void shouldContainSameAmountInTransferFromAccountAndCashLogWhenWithdraw(){

        SavingAccount stubFromAccount= mock(SavingAccount.class);
       Processing sut = new Processing();
        when(stubFromAccount.getId()).thenReturn(UUID.randomUUID());
        when(stubFromAccount.getAmount()).thenReturn(100.,0.);

        assertEquals(100.,stubFromAccount.getAmount(),0.01);
        sut.cash(100.0,stubFromAccount.getId());
        assertEquals(0.,stubFromAccount.getAmount(),0.01);
    }

    @Test
    public void shouldTransferSameAmmountFromAccountToAccountWhenDeposit(){
        SavingAccount stubToAccount =mock(SavingAccount.class);
        SavingAccount stubFromAccount= mock(SavingAccount.class);
        Processing sut = new Processing();
        when(stubToAccount.getId()).thenReturn(UUID.randomUUID());
        when(stubFromAccount.getId()).thenReturn(UUID.randomUUID());

        when(stubToAccount.getAmount()).thenReturn(0.,100.);
        when(stubFromAccount.getAmount()).thenReturn(100.,0.);

        assertEquals(100.,stubFromAccount.getAmount(),0.01);
        assertEquals(0., stubToAccount.getAmount(),0.01);
        sut.transfer(100.0,stubFromAccount.getId(),stubToAccount.getId());
        assertEquals(100.,stubToAccount.getAmount(),0.01);
        assertEquals(0., stubFromAccount.getAmount(),0.01);
    }
}
