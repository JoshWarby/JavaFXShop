package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A reward processor holds a set of products that are entitled
 * to receive reward points and can process a given cart to achieve this.
 * 
 * @author la and Josh
 */
public class RewardProcessor implements Serializable{

	private Set<Product> products;
	
	public RewardProcessor() {
		products = new HashSet<Product>();
	}
	
	public boolean addProduct(Product p) {
		return products.add(p);
	}
	
	public int rewardPoints(Cart c) {
		int points = 0;
		
		for (Order o : c)
		{
			if (products.contains(o.getProduct())) {
				c.getShopper().addRewardPoints(o.getQuantity());
				points += o.getQuantity();
			}
		}
		
		return points;
	}
	
	//added
	public Set<Product> getSet(){
		return products;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[products=" + products + "]";
	}
	
}
