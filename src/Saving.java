import java.util.InputMismatchException;

public class Saving extends Account {

	/**
	 * @author Owner: Deposit override method
	 */
	@Override
	public void Deposit() {
		double amountOfMoney = 0;
		while (amountOfMoney >= 0 || amountOfMoney < 0) {
			try {
				System.out.print("Enter the amount to deposite: ");
				amountOfMoney = BankTest.keys.nextDouble();

				if (amountOfMoney < 0) {
					throw new TransationAccountCannotBeNegative("Transaction amount cannot be negative.");
				}else if (amountOfMoney <= 3000){
					super.balance =(balance + amountOfMoney) - 0.5;
					break;
				}else {
					super.balance = (balance + amountOfMoney);
					break;
				}
			}catch (TransationAccountCannotBeNegative ne) {
				System.out.println(ne.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("Enter a valid deposit ammount...");
				BankTest.keys.next();
			}
		}
	}

	/**
	 * @author Owner: Deposit override method
	 */
	@Override
	public void Withdraw() {
		double amountOfMoney = 0;
		while (amountOfMoney >= 0 || amountOfMoney < 0) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				amountOfMoney = BankTest.keys.nextDouble();

				if (amountOfMoney > balance) {
					throw new InsufficientFundException("You account have don't have sufficent money.");
				}else if (amountOfMoney < 0) {
					throw new TransationAccountCannotBeNegative("Transaction amount cannot be negative.");
				}else if (amountOfMoney <= 3000){
					super.balance = (balance - amountOfMoney) - 0.5;
					break;
				}else {
					super.balance = (balance - amountOfMoney);
					break;
				}
			}catch (TransationAccountCannotBeNegative ne) {
				System.out.println(ne.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("Enter a valid withdraw ammount...");
				BankTest.keys.next();
			} catch (InsufficientFundException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
}
