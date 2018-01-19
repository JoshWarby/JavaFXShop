package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import model.*;
import view.*;


public class CustomerController {

	//fields to be used throughout the class
	private ShoppingRootPane view;
	private LoginPane lp;
	private static MarketPane mp;
	private CartPane cp;
	private Customer cu;
	private Name cname = new Name();
	private static Cart cart = new Cart();
	private Date date = new Date();
	private AvailableProducts ap;
	
	public CustomerController(ShoppingRootPane view, Customer cu) {
		//initialise model and view fields
		this.cu = cu;
		this.view = view;
		lp = view.getLoginPane();
		mp = view.getMarketPane();
		cp = view.getCartPane();
		
		//file to strings
		try {
			File file = new File("src/products.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				mp.addProductToList(line);
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//attach event handlers to view using private helper method
		this.attachEventHandlers();	
	}
	private void attachEventHandlers() {
		lp.addSubmitHandler(new LoginSubmitHandler()); //attaches login button handler
		mp.addToCartHandler(new AddToCartHandler());
		cp.addBuyNowHandler(new SubmitCartHandler());
	}
	
	private class AddToCartHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			boolean cont = true;
			System.out.println(mp.getSelectedItem());
			String[] selectedInfo = mp.getSelectedItem().split("      ");
			Product selectedProduct = new Product();
			selectedProduct.setProductCode(selectedInfo[0]);
			selectedProduct.setDescription(selectedInfo[1]);
			selectedProduct.setUnitPrice(Integer.parseInt(selectedInfo[2]));
			
			for (Order o : cart){
				if (o.getProduct().getProductCode().equals(selectedProduct.getProductCode())){
					cont = false;
				}
			}
			
			if (cont){
				Order productOrder = new Order();
				productOrder.setProduct(selectedProduct);
				productOrder.increaseQuantity();
				
				
				cart.addOrder(productOrder);
				cart.setCartId("CART1");
				cart.setShopper(cu);
				//cart.setDeliveryDate(deliveryDate);
				cp.updateCartView(cart);
				marketPaneCartNo();
				}
			}
	}		
	
	private class LoginSubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			cname.setFirstName(lp.getFNameInput());
			cname.setFamilyName(lp.getLNameInput());
			System.out.println(cname.toString());
			cu.setCustomerName(cname);
			String idp1 = cu.getCustomerName().getFirstName().substring(0,4);
			String idp2 = cu.getCustomerName().getFamilyName().substring(0, 4);
			cu.setCustomerId(idp1+idp2);
			System.out.println(cu.toString());
			mp.changeCustomerIDlbl(cu.getCustomerId());
			view.changeTab(1);
			}
	}
	
	private class SubmitCartHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			cart.setDeliveryDate(cp.getDate(date));
			System.out.println(cart.getDeliveryDate().toString());
			System.out.println(cart.toString());
			
			PrintWriter writer;
			try {
				writer = new PrintWriter("src/receipt.txt", "UTF-8");
				writer.println(cart.toString().replace("]], ", "]]\n").replace(", O", "\nO"));
				writer.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		}
	public static void marketPaneCartNo(){
		mp.setCartSizeLbl(cart);
	}
}