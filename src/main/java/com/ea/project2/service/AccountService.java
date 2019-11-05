package com.ea.project2.service;

import com.ea.project2.entity.Account;
import com.ea.project2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) throws Exception {
        if (account == null) {
            throw new Exception("Account is empty");
        }

        Account accountByEmail = getByEmail(account.getEmail());
        if (accountByEmail != null) {
            throw new Exception("Email is already registered");
        }

        return accountRepository.save(account);
    }


    public Account getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account getById(Long id) {
        return accountRepository.findById(id).get();
    }


    public Account updateAccount(Account postData, Long id) throws Exception {
        Account account = getById(id);

        if (account == null) {
            throw new Exception("account not found!");
        }

        account.setFirstName(postData.getFirstName());
        account.setLastName(postData.getLastName());

        return accountRepository.save(account);

    }

    public Account deleteAccount(Long id) throws Exception {
        Account account = getById(id);

        if (account == null) {
            throw new Exception("Account not found!");
        }

        accountRepository.delete(account);
        return account;
    }


}
