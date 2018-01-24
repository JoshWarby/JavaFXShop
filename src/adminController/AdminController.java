package adminController;

import model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private AvailableProducts ap;
	private RewardProcessor rp;
	private List<Product> apl;
	private List<DiscountProduct> adl;
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
		public void handle(ActionEvent e1) {
			System.out.println(ap.getAP().toString());
			grabInfo();
			ap.addAP(pp.returnEnteredP());
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
			System.out.println("added");
			grabInfo();
		}
	}
	private class RemoveSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
		    	  FileInputStream fis = new FileInputStream("src/o.tmp");
		  	      ObjectInputStream ois = new ObjectInputStream(fis);
		  	    try {
					ap = (AvailableProducts)ois.readObject();
					rp = ap.getRP();
					apl = ap.getAP();
					adl = ap.getAD();
					System.out.println(apl.toString());
					int i;
					for (i=0;i<apl.size();i++){
						if (apl.get(i).getProductCode().equals(pp.getEnteredPCode())){
							apl.remove(i);
						}
					}
					for (i=0;i<adl.size();i++){
						if (adl.get(i).getProductCode().equals(pp.getEnteredPCode())){
							adl.remove(i);
						}
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ois.close();
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ap.setAPL(apl);
			try {
		    	FileOutputStream fos = new FileOutputStream("src/o.tmp");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);
			    oos.writeObject(ap);
				oos.close();
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("removed");
			grabInfo();
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
				ap = (AvailableProducts)ois.readObject();
				rp = ap.getRP();
				apl = ap.getAP();
				adl = ap.getAD();
				
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
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ap.getAP().toString());

	}
}
