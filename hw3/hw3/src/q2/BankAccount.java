/**
 * Sebrianne Ferguson
 * CS 151 Attar
 * September 26th, 2018
 * 
 * Write a class BankAccount that implements the Comparable interface type. Order bank accounts
 * by increasing balance. Supply a test program that sorts an array list of bank accounts
 */
package q2;

public class BankAccount implements Comparable<BankAccount>{
	
	//a bank account has a balance
	int balance;
	
	/**
	 * ctor for the class
	 * @param balance to initialize
	 */
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	/**
	 * getter method
	 * @return the balance of the acct
	 */
	public int getBalance() {
		return this.balance;
	}

	@Override
	/**
	 * compareTo()
	 * @param that - a bank account to compareTo
	 */
	public int compareTo(BankAccount that) { //have to implement the compareTo method in order for the class to implement comparable
		if (this.balance > that.balance) { 
			return 1;
		}
		else if (this.balance < that.balance) {
			return -1;
		}
		else {
			return 0;
		}
	}

	
}
