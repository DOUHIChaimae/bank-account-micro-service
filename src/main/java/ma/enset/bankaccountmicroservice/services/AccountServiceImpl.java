package ma.enset.bankaccountmicroservice.services;

import ma.enset.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import ma.enset.bankaccountmicroservice.dtos.BankAccountResponseDto;
import ma.enset.bankaccountmicroservice.entities.BankAccount;
import ma.enset.bankaccountmicroservice.mappers.AccountMapper;
import ma.enset.bankaccountmicroservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDTO bankAccountRequestDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString()) //mapping
                .createdAt(new Date())
                .balance(bankAccountRequestDto.getBalance())
                .currency(bankAccountRequestDto.getCurrency())
                .type(bankAccountRequestDto.getType())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDto;
    }

    @Override
    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDTO bankAccountRequestDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountRequestDto.getBalance())
                .currency(bankAccountRequestDto.getCurrency())
                .type(bankAccountRequestDto.getType())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDto;
    }
}
