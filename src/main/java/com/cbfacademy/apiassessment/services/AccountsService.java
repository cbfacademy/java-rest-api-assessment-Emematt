package com.cbfacademy.apiassessment.services;

import com.cbfacademy.apiassessment.entities.accounts.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface AccountsService {


    Transaction createAccountTransaction(Transaction transaction);

    List<Transaction> readAllTransactions();

    void saveAllToFile(List<Transaction> transactions);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransactionById(String transactionId);

    public void deleteAllTransactions();

    public Transaction getTransactionById(String transactionId);

    public List<Transaction> getAllTransactions();


}