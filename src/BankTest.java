
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTest {

	static Scanner keys = new Scanner(System.in);

	static int WYW;																	//WYW variable to select option in whatToDo method
    /**
     * @author Owner:Select which account
     */
	public static void whatToDo() {													//Method to select which account
        System.out.println("1. Create Account");
        System.out.println("2. Transactions");
        System.out.println("3. Print all Account");
        System.out.println("4. Apply for Credit Card");
        System.out.println("5. Exit");
        System.out.print("What you want to do: ");
        WYW = BankTest.keys.nextInt();
    }

	public static void main(String[] args) {
		String bankName;															//bank name variable

		System.out.print("Enter the name of the bank: ");							//asking user to provide bank name
		bankName = keys.nextLine();


		Bank bank = new Bank(bankName);												//bank class object
		while (WYW > -1) {
//			whatToDo();
			try {																	//try block
				whatToDo();
				switch (WYW) {
				case 1:
					bank.createAccount();
//					whatToDo();
					break;
				case 2:
					bank.makeTransaction();
//					whatToDo();
					break;
				case 3:
					bank.printAccounts();
//					whatToDo();
					break;
				case 4:
					bank.CreditCardNumber();
//					whatToDo();
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid option... please select again");
//                    whatToDo();
                    break;
			}
			if (WYW == 5) {
            	System.out.println("Thanks for creating accounts... \nProgram by Shivam Patel");
            	break;
			}
		}catch (InputMismatchException ime) {									//catch InputMismatchException
			System.out.println("Invalid menu option. Try again...");
			BankTest.keys.next();
		}
	}
	keys.close();																	//closing scanner class
	}

}
