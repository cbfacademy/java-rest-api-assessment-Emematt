package com.cbfacademy.apiassessment.entities.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;


import java.util.Objects;


@ApiModel(description = "Account Class models object which categorises transactions and allows them to be aggregated by name")
public class Transaction {


    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("AccountName")
    private String accountName;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Amount")
    private double amount;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(transactionId, that.transactionId) && Objects.equals(accountName, that.accountName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountName, description, amount);
    }
}
