package at.fhv.se.banking.application.impl;

import at.fhv.se.banking.application.api.AccountService;
import at.fhv.se.banking.application.dto.AccountDTO;
import at.fhv.se.banking.application.dto.AccountDetailsDTO;
import at.fhv.se.banking.domain.model.Account;
import at.fhv.se.banking.domain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account getOrThrow(String iban) throws Exception {
        Optional<Account> result = accountRepository.getByIban(iban);
        if(result.isEmpty()) {
            throw new Exception("not found");
        }
        return result.get();
    }

    @Override
    public Optional<AccountDTO> getByIban(String iban) {
        Optional<Account> result = accountRepository.getByIban(iban);
        if(result.isEmpty()) {
            return Optional.empty();
        }

        Account account = result.get();

        return Optional.of(AccountDTO.builder().withDetails(AccountDetailsDTO.builder()
                    .withIban(account.iban())
                    .withBalance(account.balance())
                    .withType(account.type())
                .build()).build());
    }

    @Override
    public void deposit(String accountIban, double amount) throws Exception {
        getOrThrow(accountIban).deposit(amount);
    }

    @Override
    public void withdraw(String accountIban, double amount) throws Exception {
        getOrThrow(accountIban).withdraw(amount);
    }

    @Override
    public void transfer(String sendingIban, String receivingIban, double amount) throws Exception {
        getOrThrow(sendingIban).transferTo(getOrThrow(receivingIban), amount);
    }
}
