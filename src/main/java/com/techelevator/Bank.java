package com.techelevator;
import java.math.BigDecimal;

public class Bank {
    private  BigDecimal balance = BigDecimal.ZERO;

    public void addFunds(BigDecimal amount) {

        balance = balance.add(amount);
    }

    public  BigDecimal makeChange() {
        BigDecimal change = balance;
        //balance = BigDecimal.ZERO;  Was causing the balance to be set to 0 before writing change given in vending.log
        return change;
    }

    public  BigDecimal getBalance() {
        return balance;
    }

}



















