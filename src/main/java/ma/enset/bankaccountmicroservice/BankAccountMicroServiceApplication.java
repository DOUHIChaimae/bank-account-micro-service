package ma.enset.bankaccountmicroservice;

import ma.enset.bankaccountmicroservice.entities.BankAccount;
import ma.enset.bankaccountmicroservice.entities.Customer;
import ma.enset.bankaccountmicroservice.enums.AccountType;
import ma.enset.bankaccountmicroservice.repositories.BankAccountRepository;
import ma.enset.bankaccountmicroservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountMicroServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Chaimae", "Mohammed","Amina").forEach(c -> {
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                        for (int i = 0; i < 10; i++) {
                            BankAccount bankAccount = BankAccount.builder()
                                    .id(UUID.randomUUID().toString())
                                    .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                                    .balance(10000 + Math.random() * 900000)
                                    .currency("MAD")
                                    .createdAt(new Date())
                                    .customer(customer)
                                    .build();
                            bankAccountRepository.save(bankAccount);

                        }
                    }
            );

            List<BankAccount> bankAccountList = bankAccountRepository.findAll();
            for (BankAccount bankAccount : bankAccountList) {
                System.out.println("=========================");
                System.out.println(bankAccount.getId());
                System.out.println(bankAccount.getCurrency());
                System.out.println(bankAccount.getType());
                System.out.println(bankAccount.getCreatedAt());
                System.out.println(bankAccount.getBalance());
            }
        };
    }

}
