package com.cbfacademy.apiassessment.entities.accounts;


import com.cbfacademy.apiassessment.entities.user.Role;
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


    public void addTransaction(String transactionId, String accountName, String description,int amount) {
        this.transactionId = transactionId;
        this.accountName = accountName;
        this.description = description;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
