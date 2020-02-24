// Test program is in a public class called SavingsAccountTest
public class SavingsAccountTest {
	public static void main(String[] arg) {
		// Test program instantiates two SavingsAccount objects
		SavingAccount saver1 = new SavingAccount(2000.0);
		SavingAccount saver2 = new SavingAccount(3000.0);
		// Test program sets the annualInterestRate to 4%
		double newRate = 0.04;
		SavingAccount.modifyInterestRate(newRate);
		int i;
		System.out.println("Savings Account Balances");
		System.out.format("%-8s %9s %9s\n", "Month", "Saver1", "Saver2");
		// Test program calculates the monthly interest for each of the 12 months and
		// prints the monthly balances for both SavingsAccount instances as a table
		for (i = 0; i < 13; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			// Test program calculates the monthly interest for the next month's interest
			// and prints the balances for both SavingsAccount instances.
			System.out.format("%-8d %9.2f %9.2f\n", i + 1, saver1.getSavingsBalance(), saver2.getSavingsBalance());
			if (i == 11) {
				// Test program sets the annualInterestRate to 5%
				newRate = 0.05;
				SavingAccount.modifyInterestRate(newRate);
			}
		}
	}
}