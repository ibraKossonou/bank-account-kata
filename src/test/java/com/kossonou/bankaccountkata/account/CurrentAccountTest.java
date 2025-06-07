package com.kossonou.bankaccountkata.account;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.kossonou.bankaccountkata.exception.InsufficientFundsException;

public class CurrentAccountTest {
	@Test
    void should_deposit_and_withdraw_within_limit() {
        CurrentAccount account = new CurrentAccount(new BigDecimal("300.00"));
        account.deposit(new BigDecimal("1000.00"));
        account.withdraw(new BigDecimal("1200.00")); 
        assertEquals(new BigDecimal("-200.00"), account.getBalance());
    }

    @Test
    void should_throw_exception_when_exceeding_overdraft() {
        CurrentAccount account = new CurrentAccount(new BigDecimal("300.00"));
        account.deposit(new BigDecimal("100.00"));
        assertThrows(InsufficientFundsException.class,
            () -> account.withdraw(new BigDecimal("500.01")));
    }

    @Test
    void should_allow_exact_overdraft_limit() {
        CurrentAccount account = new CurrentAccount(new BigDecimal("300.00"));
        account.deposit(new BigDecimal("100.00"));
        account.withdraw(new BigDecimal("400.00")); 
        assertEquals(new BigDecimal("-300.00"), account.getBalance());
    }

    @Test
    void should_throw_exception_on_negative_deposit() {
        CurrentAccount account = new CurrentAccount(new BigDecimal("300.00"));
        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(new BigDecimal("-50.00")));
    }

    @Test
    void should_throw_exception_on_negative_withdrawal() {
        CurrentAccount account = new CurrentAccount(new BigDecimal("300.00"));
        account.deposit(new BigDecimal("100.00"));
        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("-10.00")));
    }

}
