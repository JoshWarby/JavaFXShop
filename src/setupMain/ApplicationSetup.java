package setupMain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.AvailableProducts;
import model.Cart;
import model.DiscountProduct;
import model.Product;
import model.RewardProcessor;

public class ApplicationSetup {

	public static void main(String[] args) {
		AvailableProducts ap = new AvailableProducts();
		Product p = new Product();
		p.setProductCode("E1");
		p.setDescription("Example Product");
		p.setUnitPrice(100);
		ap.addAP(p);
		
		DiscountProduct d = new DiscountProduct();
		d.setProductCode("E2");
		d.setDescription("Example Discounted");
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
