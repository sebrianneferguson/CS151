/**
 * Sebrianne Ferguson
 * CS 151 Attar
 * Instructions:
 * Write a program that computes the number of days that have elapsed since you were born. Use
 * the ZonedDateTime class, not the Day class of this chapter.
 * 
 * Credits: CS 151 Textbook and I looked at the website javaranch.com for the withDayofMonth() method.
 */
package q1;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question1 {
	
	ZonedDateTime now; //finds the current date and time in a specific time zone
	final int current_year;
	final int current_month;
	final int current_day;
	
	/**
	 * ctor for the class
	 * sets the time zone to the correct one
	 * sets final variables for the current year, month, and day 
	 */
	public Question1() {
		
		now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		current_year = now.getYear();
		current_month = now.getMonthValue();
		current_day = now.getDayOfMonth();
	}
	
	/**
	 * daysFromBirth()
	 * @param yob year of birth
	 * @param mob month of birth
	 * @param dob day of birth
	 * @return the integer number of days from the day of birth to the current day
	 */
	public int daysFromBirth(int yob, int mob, int dob) { 
		int tempYear = current_year;
		int total = 0; //keeps track of the days
		//subtract the years to get to the right year
		while (tempYear > yob) {
			//take into consideration the leap year
			if ((tempYear % 4 == 0) || ((tempYear % 100 == 0) && (tempYear % 400 == 0))){
				total += 366;
			}
			else { //not a leap year
				total += 365;
			}
			tempYear--; //move back in time by a year
		}
		
		//then once you reach the correct year, start from the end of the year and move back
		int tempMonth = current_month;
		int tempDay  = current_day;
		if ((tempMonth != mob) || (tempDay != dob)) {
			/**
			 * thought process:
			 * start at the month that is returned by getMonthValue()
			 * if that month value is less than the birth month, move forward days
			 * until you reach the end of that month, then increment the month and set day to 1
			 * do this until you get to the correct month
			 * 
			 * if the month value is greater than the birht month, move backward days
			 * until you reach the beginning of the month, then find the value of the end of the 
			 * prev month and set the day equal to that. do this until you reach the month you want
			 */
			
			if (mob > tempMonth) {
				int i = 0;
				while (mob < tempMonth) {
					ZonedDateTime endOfMonth = now.plusMonths(i).withDayOfMonth(1).minusDays(1);
					if (i == 0) { //because you're not going to add a whole month's worth of days if its not a full month
						total += endOfMonth.getDayOfMonth() - dob;
					}
					else {	
						total += endOfMonth.getDayOfMonth(); //basically the number of days in that month, add to the total
					}
					tempMonth++;
					i++;
				}
			}
			else if (mob < tempMonth) {
				int i = 0;
				while (mob < tempMonth) {
					ZonedDateTime endOfMonth = now.plusMonths(-i).withDayOfMonth(1).minusDays(1);
					if (i == 0) {
						total += dob;
					}
					else {
						total += endOfMonth.getDayOfMonth();
					}
					tempMonth--;
					i++;
				}
			}
			
			//then once you reach the month, start counting either forward or backward
			while (tempDay != dob) {
				if (tempDay > dob) { //backward
					tempDay--;
				}
				else { //foreward
					tempDay++;
				}
				total++; //either way you add a day to the total
			}
		}
		return total; //then return the final sum
	}
	
	public static void main(String[] args) {
		
		Question1 x = new Question1();
		//System.out.println(2012%4);
		//System.out.println("You have been alive for "+ x.daysFromBirth(1995, 3, 12)+ " days.");
		System.out.println("You have been alive for "+ x.daysFromBirth(1997, 9, 21)+ " days.");
		//System.out.println(x.daysFromBirth(2018, 9, 23));
		
	}
	
	
	
	
	
}
