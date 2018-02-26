package customerView;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * This is the root pane for the customer, it displays all other panes.
 * @author Josh
 *
 */
public class ShoppingRootPane extends TabPane{

	private MarketPane mp;
	private CartPane cp;
	private LoginPane lp;
	private Tab t0;
	private Tab t1;
	private Tab t2;
	

	
	public ShoppingRootPane() {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		mp = new MarketPane();
		cp = new CartPane();
		lp = new LoginPane();

	
		//create tabs with panes added
		t0 = new Tab("Login", lp);
		t1 = new Tab("Market", mp);
		t2 = new Tab("Cart", cp);

		
		//add tabs to tab pane
		this.getTabs().addAll(t0,t1,t2);
		
		setVisible(true);
		t1.setDisable(true);
		t2.setDisable(true);
		
	}
	
	/**
	 * Returns the current market pane.
	 * @return the market pane
	 */
	public MarketPane getMarketPane() {
		return mp;
	}

	/**
	 * Returns the cart pane.
	 * @return the cart pane.
	 */
	public CartPane getCartPane() {
		return cp;
	}
	
	/**
	 * Returns the login pane.
	 * @return the login pane.
	 */
	public LoginPane getLoginPane() {
		return lp;
	}
	
	/**
	 * This method enables the remaining tabs after the user enters their details on the login pane.
	 */
	public void enableTabs(){
		t1.setDisable(false);
		t2.setDisable(false);
	}
	
	/**
	 * This method changes the current tab the user is on.
	 * @param index of the tab to change to.
	 */
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
}
