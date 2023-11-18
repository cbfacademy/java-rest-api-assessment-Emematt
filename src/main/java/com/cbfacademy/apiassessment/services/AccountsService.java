package com.cbfacademy.apiassessment.services;


import com.cbfacademy.apiassessment.entities.accounts.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountsService{
    private static final String FILE_PATH= "src/main/resources/accounts.json";

    @Autowired
    ObjectMapper objectMapper;

    
    public Account createAccount(Account account) {
        String accountNo = UUID.randomUUID().toString();
        account.setAccountNumber(accountNo);
        List<Account> listOfAccounts = readAllAccounts();
        listOfAccounts.add(account);
        saveAllToFile(listOfAccounts);
        return account;
    }

    
    public List<Account> readAllAccounts() {
        List <Account> listOfAccounts = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(FILE_PATH);
            listOfAccounts = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch  (IOException e) {e.printStackTrace();}

        return listOfAccounts;
    }

    
    public void saveAllToFile(List<Account> accounts) {

        try {
            objectMapper.writeValue(new File(FILE_PATH), accounts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
    public Account updateAccount(Account account) {
        this.deleteAccountById(account.getAccountNumber());
        List<Account> listOfAccounts = readAllAccounts();
        listOfAccounts.add(account);
        saveAllToFile(listOfAccounts);

        return account;
    }
    public void deleteAllAccounts(){

        this.saveAllToFile(new ArrayList<>());

    }

    
    public void deleteAccountById(String accountNumber) {
        Account accountToBeDeleted = new Account();
        accountToBeDeleted.setAccountNumber(accountNumber);

        List<Account> listOfAccounts= readAllAccounts();
        listOfAccounts.remove(accountToBeDeleted);
        this.saveAllToFile(listOfAccounts);
    }


    public Account getAccountByNumber(String accountNumber){

        List<Account> listOfAccounts = readAllAccounts();
        for (Account account: listOfAccounts) {
            if (account.getAccountNumber().equals(accountNumber)){
                return account;}
        }
        throw new RuntimeException("No user found");
    }

    
    public List<Account> getAllAccounts() {
        return this.readAllAccounts();
    }
    
    
    
}
