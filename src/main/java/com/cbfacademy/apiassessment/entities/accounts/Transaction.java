package com.cbfacademy.apiassessment.entities.accounts;

import com.cbfacademy.apiassessment.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {


    @JsonProperty("User")

    private User user;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("TransactionId")

    private String transactionId;


    @JsonProperty("Type")
    private Type type;


    @JsonProperty("Description")
    private String description;

    @JsonProperty("Account")
    private Account account;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) && Objects.equals(transactionId, that.transactionId) && type == that.type && Objects.equals(description, that.description) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionId, type, description, account);
    }
}
