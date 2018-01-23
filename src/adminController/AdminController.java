package adminController;

import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import adminView.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AdminController {
	
	//fields to be used throughout the class
	private AdminRootPane view;
	private ProductsPane pp;
	private Customer cu;
	private DiscountsPane dp;
	public AdminController(AdminRootPane view) {
		//initialise model and view fields
		this.view = view;
		pp = view.getProductsPane();
		dp = view.getDiscountsPane();
		this.attachEventHandlers();
		
		//display products
		grabInfo();
		
	}
	private void attachEventHandlers() {
		pp.addAddHandler(new AddSubmitHandler()); //attaches add button handler
		pp.addRemoveHandler(new RemoveSubmitHandler()); //attaches add button handler
		dp.addDiscountHandler(new DiscountSubmitHandler());
	}
	private class AddSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			System.out.println("added");
		}
	}
	private class RemoveSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			System.out.println("removed");
		}
	}
	private class DiscountSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			System.out.println("discounted");
		}
	}
	
	private void grabInfo(){
		dp.clearProducts();
		pp.clearProducts();
		try {
	    	  FileInputStream fis = new FileInputStream("src/o.tmp");
	  	      ObjectInputStream ois = new ObjectInputStream(fis);
	  	    try {
				AvailableProducts ap = (AvailableProducts)ois.readObject();
				RewardProcessor rp = ap.getRP();
				List<Product> apl = ap.getAP();
				List<DiscountProduct> adl = ap.getAD();
				int i;
				for (Product tmpP : apl){
					pp.addProductToPList(tmpP);
					dp.addProductToPList(tmpP);
				}
				for (DiscountProduct tmpD : adl){
					pp.addProductToDList(tmpD);
					dp.addProductToDList(tmpD);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
