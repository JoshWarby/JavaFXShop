package model;

/**
 * A discount product is a product with a discount applied .
 * 
 * @author la
 */
public class DiscountProduct extends Product {

	//fields
	private double discountRate;
	
	
	//constructors
	public DiscountProduct() {
		super();
		discountRate = 0.2;
	}
	
	public DiscountProduct(String productCode, String description, int unitPrice, double discountRate) {
		super(productCode, description, unitPrice);
		
		if (!this.setDiscountRate(discountRate)) {
			this.discountRate = 0;
		}
	}
	
	
	//methods
	public double getDiscountRate() {
		return discountRate;
	}
	
	public boolean setDiscountRate(double discountRate) {
		if (discountRate >= 0 && discountRate <= 1.0) {
			this.discountRate = discountRate;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int getUnitPrice() {
		return super.getUnitPrice() - (int)(super.getUnitPrice()*discountRate);
	}
	
	@Override 
	public String toString() {
		return super.toString() + "[discountRate=" + discountRate + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		
		DiscountProduct other = (DiscountProduct) obj;
		
		return this.discountRate == other.discountRate;
	}	
	
}
