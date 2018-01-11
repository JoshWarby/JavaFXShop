package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import model.*;
import view.*;


public class CustomerController {

	//fields to be used throughout the class
	private ShoppingRootPane view;
	private LoginPane lp;
	private MarketPane mp;
	private CartPane cp;
	private Customer cu;
	private Name cname = new Name();
	
	public CustomerController(ShoppingRootPane view, Customer cu) {
		//initialise model and view fields
		this.cu = cu;
		this.view = view;
		lp = view.getLoginPane();
		mp = view.getMarketPane();
		cp = view.getCartPane();

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	
	}
	private void attachEventHandlers() {
		lp.addSubmitHandler(new LoginSubmitHandler()); //attaches button handler
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
	
	//public void add(Product pd){
	//	mp.
	//}
}