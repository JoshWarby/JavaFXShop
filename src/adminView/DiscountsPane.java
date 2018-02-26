package adminView;

import model.DiscountProduct;
import model.Product;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This is the discounts pane shown on the admin root pane.
 * @author Josh
 *
 */
public class DiscountsPane extends GridPane{

	private ListView plist = new ListView();
	private ListView dlist = new ListView();
    private Button btnChangeDiscount = new Button("Change Discount");
    private TextField txtID, txtDiscount;
	
	@SuppressWarnings("unchecked")
	public DiscountsPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//buttons
		this.add(btnChangeDiscount,0,3);
		Label lblID;
		lblID= new Label("Product ID");
		Label lblDiscount;
		lblDiscount = new Label("Discount (%)");
		this.add(lblID, 0, 1);
		this.add(lblDiscount, 1, 1);
		//
		
		//text fields
		txtID= new TextField();
		txtDiscount= new TextField();
		this.add(txtID, 0, 2);
		this.add(txtDiscount, 1, 2);
		
		//normal list
		plist.setCellFactory(lv -> new ListCell<Product>() {
		    @Override
		    public void updateItem(Product item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            String text = item.getProductCode()+" : "+item.getDescription()+", PRICE: "+ item.getUnitPrice()+"p" ; // get text from item
		            setText(text);
		        }
		    }
		    
		});
		plist.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				dlist.getSelectionModel().select(-1);
				}});
		
		//discounted list
		dlist.setCellFactory(lv -> new ListCell<DiscountProduct>() {
		    @Override
		    public void updateItem(DiscountProduct item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            String text = item.getProductCode()+" : "+item.getDescription()+", PRICE: "+ item.getUnitPrice()+"p(-"+item.getDiscountRate()*100+"%)" ; // get text from item
		            setText(text);
		        }
		    }
		    
		});
		dlist.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				plist.getSelectionModel().select(-1);
				}});
		
		//add lists
		this.add(plist,0,0);
		this.add(dlist,1,0);
				
	}
	
	/**
	 * This method clears the products from both lists, this allows them to be re-populated.
	 */
	public void clearProducts(){
		plist.getItems().clear();
		dlist.getItems().clear();
	}
	
	/**
	 * This method returns the product code entered by the user.
	 * @return the product code.
	 */
	public String getEnteredPCode(){
		return txtID.getText();
	}
	
	/**
	 * This method returns the entered discount rate, as a percentage.
	 * @return returns the entered discount rate.
	 */
	public double getEnteredDRate(){
		double rate;
		String enteredpercentage = txtDiscount.getText();
		rate = (double)Integer.parseInt(enteredpercentage)/(double)100;
		return rate;
	}
	
	/**
	 * This method adds a product to the products list.
	 * @param p the product to add.
	 */
	public void addProductToPList (Product p){
		plist.getItems().add(p);
	}
	
	/**
	 * This method adds a discounted product to the discounts list.
	 * @param d the discounted products to add.
	 */
	public void addProductToDList (DiscountProduct d){
		dlist.getItems().add(d);
	}

	/**
	 * This method adds the handler to the "Add Discount" button.
	 * @param handler
	 */
	public void addDiscountHandler(EventHandler<ActionEvent> handler) {
		btnChangeDiscount.setOnAction(handler);
		
	}

}
