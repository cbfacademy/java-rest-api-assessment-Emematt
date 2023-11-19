package com.cbfacademy.apiassessment.services;

import com.cbfacademy.apiassessment.entities.accounts.Transaction;

import java.util.List;

public interface TransactionServiceInterface {
    Transaction createAccountTransaction(Transaction transaction);

    List<Transaction> readAllTransactions();

    void saveAllToFile(List<Transaction> transactions);

    Transaction updateTransaction(Transaction transaction);

    void deleteAllTransactions();

    void deleteTransactionById(String transactionId);

    Transaction getTransactionByNumber(String transactionId);

    List<Transaction> getAllTransactions();
}
