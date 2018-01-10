package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class ShoppingRootPane extends TabPane{

	private MarketPane mp;
	private CartPane cp;
	
	public ShoppingRootPane() {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		mp = new MarketPane();
		cp = new CartPane();
	
		//create tabs with panes added
		Tab t1 = new Tab("Market Pane", mp);
		Tab t2 = new Tab("Cart Pane", cp);
		
		//add tabs to tab pane
		this.getTabs().addAll(t1, t2);
		
	}
	
	public MarketPane getMarketPane() {
		return mp;
	}

	public CartPane getCartPane() {
		return cp;
	}
	
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
}
