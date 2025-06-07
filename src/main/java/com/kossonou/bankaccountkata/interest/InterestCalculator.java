package com.kossonou.bankaccountkata.interest;

import java.math.BigDecimal;

public interface InterestCalculator {
	
	BigDecimal calculateInterest(BigDecimal balance);

}
