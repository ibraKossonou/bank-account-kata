package com.kossonou.bankaccountkata.interest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FixedInterestCalculator implements InterestCalculator {
	
	private final BigDecimal rate; 

    public FixedInterestCalculator(double rate) {
    	 this.rate = BigDecimal.valueOf(rate);
    }

    @Override
    public BigDecimal calculateInterest(BigDecimal balance) {
    	return balance.multiply(rate).setScale(2, RoundingMode.HALF_EVEN);
    }

}
