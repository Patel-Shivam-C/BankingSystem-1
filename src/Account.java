import java.util.InputMismatchException;

public abstract class Account {
	protected int accountNumber;																					//account number variable
    protected Person accountHolder;																					//Person class object
    protected double balance;																						//balance
    private CreditCard CC;																							//CreditCard class reference
    private int printFormate;																						//to decide which format to print. Used in toString method
    private String lastNumbers;																						//to get last number of credit card

    public Account() {};																							//non-parameterized constructor

    /**
     * @param firstName: get first name
     * @param lastName: get last name
     * @param emailId: get email id
     * @param phoneNumber: get phone number
     */
    public Account (String firstName, String lastName, String emailId, long phoneNumber) {							//parameterized constructor
    	accountHolder = new Person(firstName, lastName, emailId, phoneNumber);
    }

    /**
     * @param accNumber: get account number
     * @param fName:get first name
     * @param lName: get last name
     * @param emailAddress: get email
     * @param cellNumber: get cell number
     * @param bal: get balance
     */
    public void readDetail(int accNumber, String fName, String lName, String emailAddress, long cellNumber, double bal) {
        this.accountNumber = accNumber;
        accountHolder = new Person(fName, lName, emailAddress, cellNumber);
    	this.balance = bal;
    }

    @Override
    public String toString() {																						//override toString() method to print detail
		String ccn;
		if (printFormate==1) {
			ccn = String.format("%10d |%20s |%20s |%20d |%20.2f |%25s %n",accountNumber,accountHolder.getName(),accountHolder.getEmailId(),accountHolder.getPhoneNumber(),balance, lastNumbers);
		}else {
			ccn = String.format("%10d |%20s |%20s |%20d |%20.2f | %n",accountNumber,accountHolder.getName(),accountHolder.getEmailId(),accountHolder.getPhoneNumber(),balance);
		}
    	return ccn;
    }

    public abstract void Deposit();																					//Deposit abstract method

    public abstract void Withdraw();																				//Withdraw abstract method

    public double getBalance() {																					//get balance method
    	return balance;
    }

    /**
     * @param endingNumbers: get last for digit of credit card
     */
	public void creditCard(int endingNumbers) {
		printFormate = 1;
		System.out.println("Which type of card you want:");
		System.out.println("1. MaterCard");
		System.out.println("2. Visa");
		System.out.print("Enter your option: ");
		int whichCard = BankTest.keys.nextInt();

		while (whichCard > -1) {
			try {																										//modified
				while (whichCard < 1 || whichCard > 2) {
					System.out.println("Please enter valid card option. Try again...");
					System.out.print("Enter your option: ");
					whichCard = BankTest.keys.nextInt();
				}
				if (whichCard == 1) {
					CC = new MasterCard();
					lastNumbers = CC.cardNumber(endingNumbers);
				}
				if (whichCard == 2) {
					CC = new Visa();
					lastNumbers = CC.cardNumber(endingNumbers);
				}
				break;
			}catch (InputMismatchException ime) {																//catch InputMismatchException
	    		System.out.println("Invalid menu option. Try again...");
	    		BankTest.keys.next();
	    	}
		}

//		while(whichCard > 0) {
//			while (whichCard < 1 || whichCard > 2) {
//				System.out.println("Please enter valid card option. Try again...");
//				System.out.print("Enter your option: ");
//				whichCard = BankTest.keys.nextInt();
//			}
//			if (whichCard == 1) {
//				CC = new MasterCard();
//				lastNumbers = CC.cardNumber(endingNumbers);
//			}
//			if (whichCard == 2) {
//				CC = new Visa();
//				lastNumbers = CC.cardNumber(endingNumbers);
//			}
//			break;
//		}

	}
}
