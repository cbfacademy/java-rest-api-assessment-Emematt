package com.cbfacademy.apiassessment.entities.accounts;

import com.cbfacademy.apiassessment.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Account {


    private BigDecimal totalAmount;


    User user;


    private String accountNumber;

    private String accountName;




    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return  accountNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(totalAmount, account.totalAmount) && Objects.equals(user, account.user) && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount, user, accountNumber);
    }


}
