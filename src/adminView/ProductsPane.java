package adminView;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.callback.Callback;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.SelectionMode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.DiscountProduct;
import model.Order;
import model.Product;

public class ProductsPane extends GridPane{

	private ListView plist = new ListView();
	private ListView dlist = new ListView();
    private Button btnAddProduct = new Button("Add Product");
    private Button btnRemoveProduct = new Button("Remove (Product ID)");
    private TextField txtID, txtDesc, txtPrice;
	
	@SuppressWarnings("unchecked")
	public ProductsPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//buttons
		this.add(btnAddProduct,0,3);
		this.add(btnRemoveProduct,1,3);
		
		//labels
		Label lblID = new Label("Product ID");
		Label lblDesc = new Label("Description");
		Label lblPrice = new Label("Price (pennies)");
		this.add(lblID, 0, 1);
		this.add(lblDesc, 1, 1);
		this.add(lblPrice, 2, 1);
		
		//text fields
		txtID= new TextField();
		txtDesc= new TextField();
		txtPrice= new TextField();
		this.add(txtID, 0, 2);
		this.add(txtDesc, 1, 2);
		this.add(txtPrice, 2, 2);
		
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
	 * Returns the entered product.
	 * @return the product entered by the user.
	 */
	public Product returnEnteredP(){
		Product entered = new Product();
		entered.setDescription(txtDesc.getText());
		entered.setProductCode(txtID.getText());
		entered.setUnitPrice(Integer.parseInt(txtPrice.getText()));
		return entered;
	}
	
	/**
	 * Returns the entered product code.
	 * @return the product code entered by the user.
	 */
	public String getEnteredPCode(){
		return txtID.getText();
	}
	
	/**
	 * This method clears all products from both list, so they can be re-populated.
	 */
	public void clearProducts(){
		plist.getItems().clear();
		dlist.getItems().clear();
	}
	
	/**
	 * This method adds a product to the product list.
	 * @param p the product to add to the product list.
	 */
	public void addProductToPList (Product p){
		plist.getItems().add(p);
	}
	
	/**
	 * This method adds a discounted product to the discounts list.
	 * @param d the discounted product to be added to the discounts list.
	 */
	public void addProductToDList (DiscountProduct d){
		dlist.getItems().add(d);
	}

	/**
	 * This method attaches the handler to the "Add" button.
	 * @param handler
	 */
	public void addAddHandler(EventHandler<ActionEvent> handler) {
		btnAddProduct.setOnAction(handler);
		
	}

	/**
	 * THis method attaches the handler to the "Remove" button.
	 * @param handler
	 */
	public void addRemoveHandler(EventHandler<ActionEvent> handler) {
		btnRemoveProduct.setOnAction(handler);
		
	}
}
