import java.math.BigDecimal;

import com.kossonou.bankaccountkata.account.CurrentAccount;
import com.kossonou.bankaccountkata.account.SavingsAccount;
import com.kossonou.bankaccountkata.interest.FixedInterestCalculator;

public class App {

	public static void main(String[] args) {
		System.out.println("---- CURRENT ACCOUNT ----");
        CurrentAccount current = new CurrentAccount(new BigDecimal("300.00")); 
        current.deposit(new BigDecimal("1000.00"));
        current.withdraw(new BigDecimal("200.00"));
        current.printStatement();

        System.out.println("\n---- CURRENT SAVINGS ACCOUNT ----");
        SavingsAccount savings = new SavingsAccount(new FixedInterestCalculator(0.02));
        savings.deposit(new BigDecimal("2000.00"));
        savings.applyInterest();
        savings.withdraw(new BigDecimal("500.00"));
        savings.printStatement();

	}

}
