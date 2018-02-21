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
	private DiscountsPane dp;
	private AvailableProducts ap;
	private RewardProcessor rprocessor;
	private List<Product> apl;
	private List<DiscountProduct> adl;
	private DiscountProduct todiscounted;
	private Product toproduct;
	private RewardsPane rp;
	public AdminController(AdminRootPane view) {
		//initialise model and view fields
		this.view = view;
		pp = view.getProductsPane();
		dp = view.getDiscountsPane();
		rp = view.getRewardsPane();
		this.attachEventHandlers();
		
		//display products
		grabInfo();
		
	}
	private void attachEventHandlers() {
		pp.addAddHandler(new AddSubmitHandler()); //attaches add button handler
		pp.addRemoveHandler(new RemoveSubmitHandler()); //attaches add button handler
		dp.addDiscountHandler(new DiscountSubmitHandler());
		rp.addAddRewardHandler(new RewardAddHandler());
		rp.addRemoveRewardHandler(new RewardRemoveHandler());
	}
	private class AddSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1) {
			System.out.println(ap.getAP().toString());
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
	
	private class RewardAddHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1) {
			Product toreward = new Product();
			toreward.setProductCode(rp.getEnteredPCode());
			int i;
			for (i=0;i<apl.size();i++){
				if (apl.get(i).getProductCode().equals(rp.getEnteredPCode())){
					toreward.setDescription(apl.get(i).getDescription());
					toreward.setUnitPrice(apl.get(i).getUnitPrice());
				}
			}
			rprocessor.addProduct(toreward);
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
			System.out.println("this"+rprocessor.toString());
			grabInfo();
		}
	}
	private class RewardRemoveHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1) {
			System.out.println("y");
		}
	}
	private class RemoveSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
		    	  FileInputStream fis = new FileInputStream("src/o.tmp");
		  	      ObjectInputStream ois = new ObjectInputStream(fis);
		  	    try {
					ap = (AvailableProducts)ois.readObject();
					rprocessor = ap.getRP();
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
			try {
		    	  FileInputStream fis = new FileInputStream("src/o.tmp");
		  	      ObjectInputStream ois = new ObjectInputStream(fis);
		  	    try {
					ap = (AvailableProducts)ois.readObject();
					rprocessor = ap.getRP();
					apl = ap.getAP();
					adl = ap.getAD();
					System.out.println(apl.toString());
					int i;
					for (i=0;i<apl.size();i++){
						if (apl.get(i).getProductCode().equals(dp.getEnteredPCode())){
							todiscounted = new DiscountProduct();
							todiscounted.setProductCode(apl.get(i).getProductCode());
							todiscounted.setDescription(apl.get(i).getDescription());
							todiscounted.setUnitPrice(apl.get(i).getUnitPrice());
							todiscounted.setDiscountRate(dp.getEnteredDRate());
							ap.addDP(todiscounted);
							apl.remove(i);
						}
					}
					for (i=0;i<adl.size();i++){
						if (adl.get(i).getProductCode().equals(dp.getEnteredPCode())){
							if (dp.getEnteredDRate() == 0){
								System.out.println("is0");
								toproduct = new Product();
								toproduct.setDescription(adl.get(i).getDescription());
								toproduct.setProductCode(adl.get(i).getProductCode());
								toproduct.setUnitPrice(adl.get(i).getUnitPrice());
								ap.addAP(toproduct);
								adl.remove(i);
								
							}
							else {
								adl.get(i).setDiscountRate(dp.getEnteredDRate());
							}
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
			System.out.println("Discounted");
			grabInfo();
		}
	}
	
	private void grabInfo(){

		dp.clearProducts();
		pp.clearProducts();
		rp.clearProducts();
		//products and discounts
		try {
	    	  FileInputStream fis = new FileInputStream("src/o.tmp");
	  	      ObjectInputStream ois = new ObjectInputStream(fis);
	  	    try {
				ap = (AvailableProducts)ois.readObject();
				rprocessor = ap.getRP();
				apl = ap.getAP();
				adl = ap.getAD();
				
				int i;
				for (Product tmpP : apl){
					pp.addProductToPList(tmpP);
					dp.addProductToPList(tmpP);
					if (rprocessor.getSet().contains(tmpP)){
						System.out.println("FOUND");
						rp.addProduct(tmpP);
				}
				}
					
				for (DiscountProduct tmpD : adl){
					pp.addProductToDList(tmpD);
					dp.addProductToDList(tmpD);
				}
					
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	    System.out.println(ap.getAD().toString());
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ap.getAP().toString());

	}
	
}

