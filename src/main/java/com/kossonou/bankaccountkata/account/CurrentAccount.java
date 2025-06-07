package com.kossonou.bankaccountkata.account;

import java.math.BigDecimal;

import com.kossonou.bankaccountkata.exception.InsufficientFundsException;

public class CurrentAccount extends BankAccount  {
	private final BigDecimal overdraftLimit;

    public CurrentAccount(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }

        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(overdraftLimit.negate()) < 0) {
            throw new InsufficientFundsException("Overdraft limit");
        }

        balance = newBalance;
        recordTransaction(amount.negate());
    }
}

