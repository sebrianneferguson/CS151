package invoice;

/**
 * A line item in an invoice.
 */
public interface LineItem {
	/**
	 * Gets the price of this line item.
	 * 
	 * @return the price
	 */
	double getPrice();

	/**
	 * Gets the description of this line item.
	 * 
	 * @return the description
	 */
	
	//added by Sebrianne Ferguson
	int getQuantity();
	void increaseQuantity();
	
	String toString();
}
