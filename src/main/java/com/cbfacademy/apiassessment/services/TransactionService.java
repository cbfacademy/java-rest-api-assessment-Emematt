package com.cbfacademy.apiassessment.services;

import com.cbfacademy.apiassessment.entities.accounts.Transaction;

import java.util.List;

public interface TransactionService {


    Transaction createAccountTransaction(Transaction transaction);

    List<Transaction> readAllTransactions();

    void saveAllToFile(List<Transaction> transactions);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransactionById(String transactionId);

    void deleteAllTransactions();

    Transaction getTransactionById(String transactionId);

     List<Transaction> getAllTransactions();


}