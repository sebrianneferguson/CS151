package invoice;

/**
 * A product with a price and description.
 */
public class Product implements LineItem {
	/**
	 * Constructs a product.
	 * 
	 * @param description
	 *            the description
	 * @param price
	 *            the price
	 */
	public Product(String description, double price) {
		this.description = description;
		this.price = price;
		this.quantity = 1; //added by Sebrianne Ferguson
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return description;
	}
	
	//added by Sebrianne Ferguson
	public int getQuantity() {
		return this.quantity;
	}
	
	//added by Sebrianne Ferguson
	public void increaseQuantity() {
		this.quantity += 1;
	}

	private String description;
	private double price;
	//added by Sebrianne Ferguson
	private int quantity;
}