package com.cbfacademy.apiassessment.services;

import com.cbfacademy.apiassessment.entities.accounts.Transaction;
import com.cbfacademy.apiassessment.entities.accounts.Type;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionServiceImpl implements TransactionService {

    private static final String FILE_PATH = "src/main/resources/transactions.json";


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Transaction createAccountTransaction(Transaction transaction) {
        String transactionId = UUID.randomUUID().toString();
        transaction.setTransactionId(transactionId);
        List<Transaction> listOfTransactions = readAllTransactions();
        listOfTransactions.add(transaction);
        saveAllToFile(listOfTransactions);
        return transaction;
    }

    @Override
    public List<Transaction> readAllTransactions() {
        List<Transaction> listOfTransactions = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(FILE_PATH);
            listOfTransactions = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfTransactions;
    }

    @Override
    public void saveAllToFile(List<Transaction> transactions) {

        try {
            objectMapper.writeValue(new File(FILE_PATH), transactions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        this.deleteTransactionById(transaction.getTransactionId());
        List<Transaction> listOfTransactions = readAllTransactions();
        listOfTransactions.add(transaction);
        saveAllToFile(listOfTransactions);

        return transaction;
    }

    public void deleteAllTransactions() {

        this.saveAllToFile(new ArrayList<>());

    }

    @Override
    public void deleteTransactionById(String transactionId) {
        Transaction transactionToBeDeleted = new Transaction();
        transactionToBeDeleted.setTransactionId(transactionId);

        List<Transaction> listOfTransactions = readAllTransactions();
        listOfTransactions.remove(transactionToBeDeleted);
        this.saveAllToFile(listOfTransactions);
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        List<Transaction> listOfTransactions = readAllTransactions();
        for (Transaction transaction : listOfTransactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        throw new RuntimeException("No transaction found");
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return this.readAllTransactions();
    }


    public BigDecimal sumDebitsInAccount(Type debit, String accountName) {

        List<Transaction> listOfTransactions = readAllTransactions();
        BigDecimal totalDebits = listOfTransactions.stream().
                filter(transaction -> transaction.getType().equals(debit)).
                filter(transaction -> transaction.getAccount().equals(accountName)).
                map(Transaction::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);

        return totalDebits;
    }
    public BigDecimal SumCreditsInAccount(Type credit, String accountName) {

        List<Transaction> listOfTransactions = readAllTransactions();
        BigDecimal totalCredits = listOfTransactions.stream().
                filter(transaction -> transaction.getType().equals(credit)).
                filter(transaction -> transaction.getAccount().equals(accountName)).
                map(Transaction::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);

        return totalCredits;
    }

}
