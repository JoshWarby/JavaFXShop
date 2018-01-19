package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AvailableProducts implements Serializable{
	private Set<Product> AvailableProducts;
	private Set<DiscountProduct> AvailableDiscounted;
	private RewardProcessor Rewards;
	
	public AvailableProducts(){
		AvailableProducts = new HashSet<Product>();
		AvailableDiscounted = new HashSet<DiscountProduct>();
		Rewards = new RewardProcessor();
	}
	
	public void addAP(Product p){
		AvailableProducts.add(p);
	}
	public void addDP(DiscountProduct d){
		AvailableDiscounted.add(d);
	}
	public void addRP(RewardProcessor r){
		Rewards = r;
	}

}
