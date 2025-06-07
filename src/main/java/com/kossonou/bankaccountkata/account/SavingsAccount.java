package com.kossonou.bankaccountkata.account;

import java.math.BigDecimal;

import com.kossonou.bankaccountkata.exception.InsufficientFundsException;
import com.kossonou.bankaccountkata.interest.InterestCalculator;

public class SavingsAccount extends BankAccount {
	
	private final InterestCalculator interestCalculator;

    public SavingsAccount(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount== null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientFundsException("Insufficient funds for savings account");
        }
        
        balance = balance.subtract(amount);
        recordTransaction(amount.negate());
    }

    public void applyInterest() {
        BigDecimal interest = interestCalculator.calculateInterest(balance);
        balance = balance.add(interest);
        recordTransaction(interest);
    }
}
