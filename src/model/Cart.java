package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * A shopping cart holds a list of orders, and has an associated customer,
 * date of delivery and a unique id.
 * 
 * Orders can be added, removed and retrieved from the cart, whilst it is
 * also possible to check the number of orders in the cart, clear its contents
 * and check if it is empty.
 * 
 * The total cost of all orders in the cart can be retrieved, and an order can
 * be searched for by providing a product code.
 * 
 * @author la
 */
public class Cart implements Iterable<Order>, Serializable {

	//fields
	private List<Order> contents;
	private Customer shopper;
	private Date deliveryDate;
	private String cartId;
	
	
	//constructors
	public Cart() {
		contents = new ArrayList<Order>();
		shopper = new Customer();
		deliveryDate = new Date();
		cartId = "Not set";
	}
	
	public Cart(Customer shopper, Date deliveryDate, String cartId) {
		contents = new ArrayList<Order>();
		this.shopper = shopper;
		this.deliveryDate = deliveryDate;
		this.cartId = cartId;
	}
	
	
	//methods
	public void addOrder(Order o) {
		contents.add(o);
	}
	
	public void removeOrder(int i) {
		contents.remove(i);
	}
	
	public void clear() {
		contents.clear();
	}
	
	public Order getOrder(int i) {
		return contents.get(i);
	}
	
	public int numberOfOrders() {
		return contents.size();
	}
	
	public int getTotalCost() {
		int total = 0;
		for (Order o : contents) {
			total+= o.getCost();
		}
		return total;
	}
	
	public boolean isEmpty() {
		return contents.isEmpty();
	}
	
	public Order findOrder(String productCode) {
		for(Order o : contents) {
			if (o.getProduct().getProductCode().equals(productCode)) {
				return o;
			}
		}
		return null;
	}
	
	public void sortOrders() {
		Collections.sort(contents);
	}
	
	public boolean containsOrder(Order o) {
		return contents.contains(o);
	}
	
	public boolean removeOrder(Order o) {
		return contents.remove(o);
	}
	
	public Customer getShopper() {
		return shopper;
	}

	public void setShopper(Customer shopper) {
		this.shopper = shopper;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[contents=" + contents + 
				", shopper=" + shopper + 
				", deliveryDate=" + deliveryDate + 
				", cartId=" + cartId + "]";
	}
	
	@Override
	public Iterator<Order> iterator() {
		return contents.iterator();
	}
	
}
