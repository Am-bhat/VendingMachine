package com.techelevator;

import java.math.BigDecimal;

public class MoneyHolder extends VendingMachineCLI{

    private BigDecimal balance = new BigDecimal(0);

    public MoneyHolder(){
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
