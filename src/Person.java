/*
 * Name: Shivam Patel
 * Lab Professor: James Mwangi
 * Due Date: March 11th, 2022
 * Modified: March 15th, 2022
 * Description: Lab 5 - Banking Management System II  
 */

public class Person {
	private String firstName;												//first name variable
	private String lastName;												//second name variable
	private String emailId;													//email variable
	private long phoneNumber;												//phone number variable							
	
	/**
	 * Parameterized constructor
	 * @param name1: First name
	 * @param name2: Second name
	 * @param eId: Email ID
	 * @param cellNum: Cell Number
	 */
	public Person(String name1,String name2, String eId, long cellNum){		//creating parameterized constructor
        this.firstName = name1;
        this.lastName = name2;
        this.emailId = eId;
        this.phoneNumber = cellNum;
    }

	/**
	 * @return: return person full name in string formate
	 */
	public String getName(){												//getter method for name
		return firstName+" "+lastName;
	}

	/**
	 * @return: return person email id
	 */
	public String getEmailId(){												//getter method for email
		return emailId;
	}

	/**
	 * @return: return person cell Number
	 */
	public long getPhoneNumber(){											//getter method for cell number
		return phoneNumber;
	}
}
