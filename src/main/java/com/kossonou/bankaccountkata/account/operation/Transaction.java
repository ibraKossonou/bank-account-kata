package com.kossonou.bankaccountkata.account.operation;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction (LocalDate date, BigDecimal amount, BigDecimal balanceAfter) { }
