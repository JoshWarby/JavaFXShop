package model;


/**
 * An order can be placed for a given quantity of a item
 * The cost of the order is given in pence and is calculated by
 * multiplying the order quantity with the item's unit price.
 *
 * The quantity of an order can be increased and decreased.
 *
 * Two orders are equal if their associated items are the same.
 * Orders can also be compared by their associated items.
 *
 * @author la
 */
public class Order implements Comparable<Order> {

	//fields
	private Product item;
	private int quantity;

	
	//constructors
	public Order() {
		item = new Product();
		quantity = 0;
		
	}

	public Order(Product item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	
	//methods
	public void increaseQuantity() {
		quantity++;
	}

	public void decreaseQuantity() {
		quantity--;
	}

	public int getCost() {
		return quantity * item.getUnitPrice();
	}

	public Product getProduct() {
		return item;
	}
	
	public void setProduct(Product item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[item=" + item + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Order other = (Order) obj;

		return this.item.equals(other.item);
	}

	@Override
	public int compareTo(Order other) {
		return this.item.compareTo(other.item);
	}

}
