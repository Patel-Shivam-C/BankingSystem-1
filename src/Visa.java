
public class Visa  implements CreditCard{

	/**
	 * @param endNum: to create last four digit of credit card
	 * @return: return card number
	 */
	@Override
	public String cardNumber(int endNum) {
		return "442212345678"+endNum+" (V)";
	}

}
