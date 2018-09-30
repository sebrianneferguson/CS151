/**
 * Sebrianne Ferguson
 * CS 151 Attar
 * Implements a test for the bank accounts
 */
package q2;

import java.util.ArrayList;

public class Question2 {
	
	ArrayList<BankAccount> acnts; //for all of the BankAccounts
	
	/**
	 * ctor
	 */
	public Question2() {
		acnts = new ArrayList<BankAccount>();
	}
	
	/**
	 * stor()
	 * @param a an arraylist of bankaccounts
	 * @return
	 */
	public ArrayList<BankAccount> sort(ArrayList<BankAccount> a) {
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		//selection sort
		for (int i = 0; i < a.size(); i++) { //for every element of the list
			BankAccount smallest = a.get(i); //set to the smallest of the range
			int index = 0; //need this to keep track of where you're swapping at in the end
			for (int j = i; j < a.size(); j++) { //for every element after it
				if (a.get(j).compareTo(smallest) == -1) { //if the element is smaller than the current smaller one
					smallest = a.get(j); //then replace smallest with that
					index = j;
				}
			}
			a.set(index, a.get(i));
			a.set(i, smallest);
			sorted.add(smallest);
			//then do a simple swap
		}
		
		return sorted;
	}
	
	public static void main(String[] args) {
		
		Question2 x = new Question2();
		//test
		BankAccount a = new BankAccount(33002);
		x.acnts.add(a);
		BankAccount b = new BankAccount(3756789);
		x.acnts.add(b);
		BankAccount c = new BankAccount(44);
		x.acnts.add(c);
		BankAccount d = new BankAccount(123456789);
		x.acnts.add(d);
		BankAccount e = new BankAccount(10);
		x.acnts.add(e);
		
		//print each of the balances
		ArrayList<BankAccount> sorted = x.sort(x.acnts);
		for (BankAccount account: sorted) {
			System.out.println(account.getBalance());
		}
	}
	
	

}
