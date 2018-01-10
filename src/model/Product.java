package model;

import java.util.Objects;

/**
 * A product item has a unique product code, description, 
 * and price per unit. The price is given in pence.
 * 
 * @author la
 */
public class Product implements Comparable<Product> {
	
	//fields
	private String productCode;
	private String description;
	private int unitPrice; //in pence
	
	
	//constructors
	public Product() {
		this("000-000", "Empty Product", 0);
	}
	
	public Product(String productCode, String description, int unitPrice) {
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	
	//methods
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public String getDescription() {
		return description;
	}

	public int getUnitPrice() {
		return unitPrice;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[productCode=" + productCode 
				+ ", description=" + description
				+ ", unitPrice =" + unitPrice + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || this.getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
		
		return description.equals(other.description)
				&& unitPrice == other.unitPrice
				&& productCode.equals(other.productCode);
	}
	
	@Override
	public int compareTo(Product other) {
		int result = getProductCode().compareTo(other.getProductCode());
	
		if (result == 0) {
			result = getDescription().compareTo(other.getDescription());
			
			if (result == 0) {
				Integer.compare(getUnitPrice(), other.getUnitPrice());
			}
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productCode, unitPrice, description);
	}

	
}
