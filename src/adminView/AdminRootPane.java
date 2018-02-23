package adminView;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import adminView.*;

public class AdminRootPane extends TabPane{

	private ProductsPane pp;
	private DiscountsPane dp;
	private RewardsPane rp;
	
	public AdminRootPane() {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		pp = new ProductsPane();
		dp = new DiscountsPane();
		rp = new RewardsPane();
	
		//create tabs with panes added
		Tab t0 = new Tab("Add/Remove", pp);
		Tab t1 = new Tab("Discounts",dp);
		Tab t3 = new Tab("Rewards Scheme",rp);
		
		//add tabs to tab pane
		this.getTabs().addAll(t0,t1,t3);
		
		setVisible(true);
		
	}
	
	/**
	 * Returns the product pane.
	 * @return the product pane.
	 */
	public ProductsPane getProductsPane() {
		return pp;
	}
	
	/**
	 * Returns the discounts pane.
	 * @return the discount pane.
	 */
	public DiscountsPane getDiscountsPane() {
		return dp;
	}
	
	/**
	 * Returns the rewards pane.
	 * @return the reward pane.
	 */
	public RewardsPane getRewardsPane() {
		return rp;
	}

	/**
	 * This method changes the current tab the user is on.
	 * @param index of the tab to change to.
	 */
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
}
