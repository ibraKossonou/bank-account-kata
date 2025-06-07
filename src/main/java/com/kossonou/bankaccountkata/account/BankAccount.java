package com.kossonou.bankaccountkata.account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kossonou.bankaccountkata.account.operation.Transaction;

public abstract class BankAccount {
	
	protected BigDecimal balance = BigDecimal.ZERO;
    protected final List<Transaction> transactions = new ArrayList<>();

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance = balance.add(amount);
        recordTransaction(amount);
    }

    public abstract void withdraw(BigDecimal amount);

    protected void recordTransaction(BigDecimal amount) {
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    public void printStatement() {
        System.out.println("DATE       | AMOUNT    | BALANCE");
        for (Transaction t : transactions) {
            System.out.printf("%s | %9.2f | %8.2f%n",
                t.date(),
                t.amount(),
                t.balanceAfter());
        }
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
