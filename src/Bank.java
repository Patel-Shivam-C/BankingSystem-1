import java.util.ArrayList;
import java.util.InputMismatchException;

public class Bank {

	private String name;																							//name variable
	private int count;																								//count variable for how many people are registering
	private ArrayList<Account> accounts = new ArrayList<Account>(count);											//Account class in ArrayList
	private int printFormate; 																						//to decide which format to print. Used in printTitle method

    public Bank(){}																									//non-parameterized constructor

    /**
     * @param name: Bank Name
     */
    public Bank(String name) {																						//parameterized constructor
        this.name = name;
    }

    public void printTitle(){																						//Method to print the title
    	if (printFormate == 1) {
    		System.out.println("***********************************************************************************************************************************");
        	System.out.printf("%45S BANK %n", name);
        	System.out.println("***********************************************************************************************************************************");
            System.out.printf("%s |%20s |%20s |%20s |%20s |%25s %n","Acc Number","Name","Email","Phone Number","Balance", "Credit Card");
            System.out.println("***********************************************************************************************************************************");
    	}else {
    		System.out.println("*************************************************************************************************************************");
        	System.out.printf("%45S BANK %n", name);
        	System.out.println("*************************************************************************************************************************");
    		System.out.printf("%s |%20s |%20s |%20s |%20s | %n","Acc Number","Name","Email","Phone Number","Balance");
            System.out.println("*************************************************************************************************************************");
    	}
    }

    private int accType;																							//account type variable. Used in accountType() method
    public void accountType() {
    	System.out.println("1. Chequing");
    	System.out.println("2. Saving");
    	System.out.print("Which type of account:  ");
    	accType = BankTest.keys.nextInt();
    }

    /**
     *@author Owner: print account holder detail
     */
    public void printAccounts(){																					//method to print details
        if (count<=0) {
        	System.out.println("Your need to create account first");
        }else {
        	printTitle();
        	for(int i=0;i<accounts.size();i++){
        		System.out.println(accounts.get(i));
        	}
        }
    }

    /**
     * @author Owner: to create account
     */
    public void createAccount() {																					//method to create account
    	if (count>-1&&count<=accounts.size()) {
	    	System.out.print("Enter first name: "+BankTest.keys.nextLine());										//asking first name
	        String name1 = BankTest.keys.nextLine();
	        System.out.print("Enter last name: ");																	//asking last name
	        String name2 = BankTest.keys.nextLine();
	        System.out.print("Enter email: ");																		//asking email id
	        String email = BankTest.keys.nextLine();
	        System.out.print("Enter phone number: ");																//asking phone number
	        long phone = BankTest.keys.nextLong();

	    	System.out.println("Select account type:-");
//	        accountType();
	        while (accType > -1) {
	        	 try {																								//try block
		        	 accountType();
		        	 while (accType > -1) {
		 	        	while (accType < 1 || accType > 2) {
		 	        		System.out.println("Invalid menu option. Try again...");
		 	        		accountType();
		 	        	}
		 	        	if (accType == 1) {																			//setting account to chequing type
		 	        		Account CA = new Chequing();
		 	        		CA.readDetail((count+1), name1, name2, email, phone, 0);
		 	        		accounts.add(CA);
		 	        	}
		 	        	if (accType == 2) {																			//setting account to saving type
		 	        		Account SA = new Saving();
		 	        		SA.readDetail((count + 1), name1, name2, email, phone, 0);
		 	        		accounts.add(SA);
		 	        	}
		 	        	break;
		 	        }
		 	        count++;
		 	        printAccounts();
		 	        break;
		        }catch (InputMismatchException ime) {																//catch InputMismatchException
	        		System.out.println("Invalid menu option. Try again...");
	        		BankTest.keys.next();
	        	}
	        }
    	}
    }


    private int selectOption;																						//selectOption variable. Used in whatTypeOfTransaction() method
    /**
     * @author Owner: method to select what type of transaction
     */
    public void whatTypeOfTransaction() {
    	System.out.println("What would you like to do: ");
    	System.out.println("1. Deposit");
    	System.out.println("2. Withdraw");
    	System.out.println("3. Balance");
    	System.out.print("Enter your option: ");
    	selectOption = BankTest.keys.nextInt();
    }

    public void DWA(int accTans) {
    	while (accTans <= accounts.size()) {
    		try {
    			while (selectOption > -1) {
    				whatTypeOfTransaction();
    				while (selectOption < 1 || selectOption > 3) {
    					System.out.println("Invalid menu option. Try again...");
    					whatTypeOfTransaction();
    	     		}
    				if (selectOption == 1) {
    					accounts.get(accTans-1).Deposit();
//    	       			printAccounts();
    					printTitle();
    					System.out.println(accounts.get(accTans-1));
    				}
    				if (selectOption == 2) {
    					accounts.get(accTans-1).Withdraw();
//    	       			printAccounts();
    					printTitle();
    					System.out.println(accounts.get(accTans-1));
    				}
    				if (selectOption == 3) {
    					System.out.println("Account balance is "+accounts.get(accTans-1).getBalance()+" dollars");   //modified line
    				}
    				break;
    			}
    			break;
    		}catch (InputMismatchException ime) {																//catch InputMismatchException
    			System.out.println("Invalid menu option. Try again...");
    			BankTest.keys.next();
    		}
    	}
    }

    /**
     * @author Owner: method to do transaction
     */
    public void makeTransaction() {
    	if (count<=0) {
        	System.out.println("Your need to create account first");
        }else {
        	int whichAccount = 0;
        	printAccounts();

        	while (whichAccount >= 0 || whichAccount < 0) {
        		try {																								//try block

        			System.out.print("Enter account number: ");
            		whichAccount = BankTest.keys.nextInt();

            		if (whichAccount <= 0 || whichAccount > accounts.size()) {										//throw an exception
            			throw new AccountNotFoundException("Account number entered "+whichAccount+" is not found. Try again...");
            		}
            		DWA(whichAccount);
//            		if (whichAccount <= accounts.size()) {
//            			while (selectOption > -1) {
//            				whatTypeOfTransaction();
//            				while (selectOption < 1 || selectOption > 3) {
//            					System.out.println("Invalid menu option. Try again...");
//            					whatTypeOfTransaction();
//            	     		}
//            				if (selectOption == 1) {
//            					accounts.get(whichAccount-1).Deposit();
////            	       			printAccounts();
//            					printTitle();
//            					System.out.println(accounts.get(whichAccount-1));
//            				}
//            				if (selectOption == 2) {
//            					accounts.get(whichAccount-1).Withdraw();
////            	       			printAccounts();
//            					printTitle();
//            					System.out.println(accounts.get(whichAccount-1));
//            				}
//            				if (selectOption == 3) {
//            					System.out.println("Account balance is "+accounts.get(whichAccount-1).getBalance()+" dollars");   //modified line
//            				}
//            				break;
//            			}
//            			break;
//            		}
            		break;
            	}catch(AccountNotFoundException anf) {																//catch AccountNotFoundException
            		System.out.println(anf.getMessage());
            	}catch (InputMismatchException ime) {																//catch InputMismatchException
            		System.out.println("Invalid menu option. Try again...");
            		BankTest.keys.next();
            	}
        	}
        }
    }


    private int lastFourCardNumbers = 1000;																			//variable lastFourCardNumbers. Used in CreditCardNumber method
    /**
     * @author Owner: method to get credit card number
     */
    public void CreditCardNumber() {
    	if (count<=0) {
        	System.out.println("Your need to create account first");
        }else {
        	int whichAccount = 0;
        	lastFourCardNumbers++;
        	printAccounts();
        	printFormate = 1;
        	while (whichAccount >= 0 || whichAccount < 0) {
        		try {																								//try block
            		System.out.print("Enter account number: ");
            		whichAccount = BankTest.keys.nextInt();

            		if (whichAccount <= 0 || whichAccount > accounts.size()) {
            			throw new AccountNotFoundException("Account number entered "+whichAccount+" is not found. Try again...");
            		}

            		if (whichAccount <= accounts.size()) {
            			accounts.get(whichAccount-1).creditCard(lastFourCardNumbers);
            		}
//            		printAccounts();
            		printTitle();
	        		System.out.println(accounts.get(whichAccount-1));
            		break;
            	}catch (AccountNotFoundException ane) {																//catch AccountNotFoundException
            		System.out.println(ane.getMessage());
            	}catch (InputMismatchException ime) {																//catch InputMismatchException
            		System.out.println("Invalid menu option. Try again...");
            		BankTest.keys.next();
            	}
        	}
        }
    }
}
