package ma.enset.bankaccountmicroservice.entities;

import ma.enset.bankaccountmicroservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();

    public AccountType getType();

}
