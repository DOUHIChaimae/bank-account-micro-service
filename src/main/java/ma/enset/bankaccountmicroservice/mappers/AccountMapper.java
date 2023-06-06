package ma.enset.bankaccountmicroservice.mappers;

import ma.enset.bankaccountmicroservice.dtos.BankAccountResponseDto;
import ma.enset.bankaccountmicroservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDto);
        return bankAccountResponseDto;
    }

    public BankAccount fromBankAccountDTO(BankAccountResponseDto bankAccountResponseDto) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountResponseDto, bankAccount);
        return bankAccount;
    }
}
