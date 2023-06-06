package ma.enset.bankaccountmicroservice.services;


import ma.enset.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import ma.enset.bankaccountmicroservice.dtos.BankAccountResponseDto;

public interface AccountService {
    public BankAccountResponseDto addAccount(BankAccountRequestDTO bankAccountDTO);

    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
