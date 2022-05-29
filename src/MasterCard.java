/*
 * Name: Shivam Patel
 * Lab Professor: James Mwangi
 * Due Date: March 11th, 2022
 * Modified: March 15th, 2022
 * Description: Lab 5 - Banking Management System II  
 */

public class MasterCard implements CreditCard{

	/**
	 * @param endNum: to create last four digit of credit card
	 * @return: return card number
	 */
	@Override
	public String cardNumber(int endNum) {
		return "552212345678"+endNum+" (MC)";
	}

	
}
