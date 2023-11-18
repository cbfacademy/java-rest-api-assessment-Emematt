package com.cbfacademy.apiassessment.entities.accounts;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {


    private BigDecimal amount;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String transactionId;

    private Type type;

    private Status status;
    private String description;

    private Account account;


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
        return Objects.equals(amount, that.amount) && Objects.equals(transactionId, that.transactionId) && type == that.type && status == that.status && Objects.equals(description, that.description) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionId, type, status, description, account);
    }
}
