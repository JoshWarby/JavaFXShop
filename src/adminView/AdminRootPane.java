package adminView;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import view.CartPane;
import view.LoginPane;
import view.MarketPane;

public class AdminRootPane extends TabPane{

	private ProductsPane pp;
	private DiscountsPane dp;
	
	public AdminRootPane() {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		pp = new ProductsPane();
		dp = new DiscountsPane();
	
		//create tabs with panes added
		Tab t0 = new Tab("Add/Remove", pp);
		Tab t1 = new Tab("Discounts",dp);
		
		//add tabs to tab pane
		this.getTabs().addAll(t0,t1);
		
		setVisible(true);
		
	}
	
	public ProductsPane getProductsPane() {
		return pp;
	}
	
	public DiscountsPane getDiscountsPane() {
		return dp;
	}

	
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
}
