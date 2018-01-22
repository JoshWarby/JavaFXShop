package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestOS {

	public static void main(String[] args) {
		AvailableProducts ap = new AvailableProducts();
		Product p = new Product();
		p.setDescription("PRODUCT");
		p.setProductCode("NORM");
		p.setUnitPrice(10);
		ap.addAP(p);
		
		DiscountProduct d = new DiscountProduct();
		d.setDescription("DISCOUNTED PRODUCT");
		d.setProductCode("DISCOUNTED");
		d.setUnitPrice(100);
		d.setDiscountRate(0.2);
		ap.addDP(d);
		
		RewardProcessor r = new RewardProcessor();
		r.addProduct(p);
		ap.addRP(r);
		
		Cart c = new Cart();
		ap.setCart(c);
		
	    try {
	    	FileOutputStream fos = new FileOutputStream("src/o.tmp");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(ap);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 

	}

}
