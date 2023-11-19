package com.cbfacademy.apiassessment.controllers;


import com.cbfacademy.apiassessment.entities.accounts.Transaction;
import com.cbfacademy.apiassessment.services.TransactionService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generalLedger")
@ApiModel(description = "Account Controller functions as intermediary between user and business logic")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = this.transactionService.getAllTransactions();
        return  new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @GetMapping("/getTransactionById/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable String transactionId){
        Transaction transaction = this.transactionService.getTransactionByNumber(transactionId);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @ApiOperation(value = "Add transaction details", notes = "Adds new details for transaction")

    @PostMapping("/addTransaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        transaction = this.transactionService.createAccountTransaction(transaction);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @PostMapping("/updateAccount/{transactionId}")
    public ResponseEntity<Transaction> updateAccount(@PathVariable String transactionId, @RequestBody Transaction transaction)  {
        transaction = this.transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @DeleteMapping("/deleteTransactionByNumber/{transactionId}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable String transactionId){
        this.transactionService.deleteTransactionById(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllTransactions")
    public ResponseEntity<HttpStatus> deleteAllTransactions(){
        this.transactionService.deleteAllTransactions();
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
