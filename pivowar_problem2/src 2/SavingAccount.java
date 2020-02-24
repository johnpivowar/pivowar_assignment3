// SavingsAccount is a public class
public class SavingAccount {
	// annualInterestRate is a private class variable
	private static double annualInterestRate;
	// savingsBalance is a private instance variable
	private double savingsBalance;

	// calculateMonthlyInterest is a public instance method
	public void calculateMonthlyInterest() {
		// calculateMonthlyInterest is correctly implemented
		savingsBalance += (savingsBalance * annualInterestRate / 12.0);
	}

	public static void setInterestRate(double rate) {
		annualInterestRate = rate;
	}

	// modifyInterestRate is a public class method
	public static double modifyInterestRate(double newRate) {
		// modifyInterestRate is correctly implemented
		SavingAccount.setInterestRate(newRate);
		return newRate;
	}

	public void setSavingsBalance(double balance) {
		savingsBalance = balance;
	}

	public SavingAccount(double balance) {
		setSavingsBalance(balance);
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}
}