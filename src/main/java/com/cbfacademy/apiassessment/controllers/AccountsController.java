package com.cbfacademy.apiassessment.controllers;


import com.cbfacademy.apiassessment.entities.accounts.Account;
import com.cbfacademy.apiassessment.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/trialBalance")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;


    @GetMapping("/users")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = this.accountsService.getAllAccounts();
        return  new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @GetMapping("/getAccountByNumber/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber){
        Account account = this.accountsService.getAccountByNumber(accountNumber);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @GetMapping("/getAccountBalanceByName/{accountName}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable String accountName){
        BigDecimal balance= this.accountsService.getAccountBalanceByName(accountName);
        return new ResponseEntity<>(balance,HttpStatus.OK);
    }


    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        account = this.accountsService.createAccount(account);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping("/updateAccount/{accountName}")
    public ResponseEntity<Account> updateAccount(@PathVariable String accountName, @RequestBody Account account)  {
        account = this.accountsService.updateAccount(account);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @DeleteMapping("/deletAccountsNumber/{accountNumber}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable String accountNumber){
        this.accountsService.deleteAccountById(accountNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllAccounts")
    public ResponseEntity<HttpStatus> deleteAllAccounts(){
        this.accountsService.deleteAllAccounts();
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
