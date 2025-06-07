package com.kossonou.bankaccountkata.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.kossonou.bankaccountkata.exception.InsufficientFundsException;
import com.kossonou.bankaccountkata.interest.FixedInterestCalculator;

public class SavingsAccountTest {
	
	@Test
    void should_deposit_and_withdraw_within_balance() {
        SavingsAccount account = new SavingsAccount(new FixedInterestCalculator(0.02));
        account.deposit(new BigDecimal("1000.00"));
        account.withdraw(new BigDecimal("200.00"));
        assertEquals(new BigDecimal("800.00"), account.getBalance());
    }

    @Test
    void should_throw_exception_when_withdrawing_more_than_balance() {
        SavingsAccount account = new SavingsAccount(new FixedInterestCalculator(0.02));
        account.deposit(new BigDecimal("500.00"));
        assertThrows(InsufficientFundsException.class,
            () -> account.withdraw(new BigDecimal("600.00")));
    }

    @Test
    void should_apply_interest_correctly() {
        SavingsAccount account = new SavingsAccount(new FixedInterestCalculator(0.05));
        account.deposit(new BigDecimal("1000.00"));
        account.applyInterest();
        assertEquals(new BigDecimal("1050.00"), account.getBalance());
    }

    @Test
    void should_throw_exception_on_invalid_deposit_and_withdrawal() {
        SavingsAccount account = new SavingsAccount(new FixedInterestCalculator(0.02));

        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(new BigDecimal("-10.00")));

        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("-10.00")));
    }

}
