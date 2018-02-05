package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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
		t0 = new Tab("Login Pane", lp);
		t1 = new Tab("Market Pane", mp);
		t2 = new Tab("Cart Pane", cp);

		
		//add tabs to tab pane
		this.getTabs().addAll(t0,t1,t2);
		
		setVisible(true);
		t1.setDisable(true);
		t2.setDisable(true);
		
	}
	
	
	public MarketPane getMarketPane() {
		return mp;
	}

	public CartPane getCartPane() {
		return cp;
	}
	
	public LoginPane getLoginPane() {
		return lp;
	}
	
	public void enableTabs(){
		t1.setDisable(false);
		t2.setDisable(false);
	}
	
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
}
