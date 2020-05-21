package test.java.com.acme.banking.dbo;

import main.java.com.acme.banking.dbo.domain.Client;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientTest {
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
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "");
        //endregion

        //region then

        //endregion
    }
    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullNameWhenCreated(){
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, null);
        //endregion

        //region then

        //endregion
    }
    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowNullIdWhenCreated(){
        //region given

        //endregion

        //region when
        Client sut = new Client(null, "dummy client name");
        //endregion

        //region then

        //endregion
    }
}
