package com.ea.project2.controller;

import com.ea.project2.entity.Account;
import com.ea.project2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public Account createAccount(@RequestBody Account account) throws Exception {
        return accountService.createAccount(account);
    }

    @PatchMapping("/{id}")
    public Account updateAccount(@PathVariable("id") Long id, @RequestBody Account account) throws Exception {
        return accountService.updateAccount(account, id);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Account deleteById(@PathVariable("id") Long id) throws Exception {
        return accountService.deleteAccount(id);
    }
}
