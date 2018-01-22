package model;

import java.io.Serializable;

/**
 * A customer has a name and customer identity number
 * and a number of reward points.
 * 
 * @author la
 */
public class Customer implements Serializable {

	//fields
	private Name customerName;
	private String customerId;
	private int rewardPoints;
	
	
	//constructors
	public Customer() {
		customerName = new Name();
		customerId = "";
		rewardPoints = 0;
	}
	
	public Customer(Name customerName, String customerId) {
		this.customerName = customerName;
		this.customerId = customerId;
		rewardPoints = 0;
	}

	
	//methods
	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	
	public void addRewardPoints(int rewardPoints) {
		this.rewardPoints += rewardPoints;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[customerName=" + customerName +
				", customerId=" + customerId + ", rewardPoints=" + rewardPoints + "]";
	}
	
}
