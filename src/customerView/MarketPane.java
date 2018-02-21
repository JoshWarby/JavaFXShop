package customerView;

import model.Cart;
import javafx.scene.text.TextAlignment;
import model.DiscountProduct;
import model.Product;
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


public class MarketPane extends GridPane{
	
	private Label customerIDlbl = new Label("Cart will be saved upon closure.");
	//TableView table = new TableView();
	private ListView plist = new ListView();
	private ListView dlist = new ListView();
    private Button btnAddCart = new Button("Add to Cart");
    private Label lblInCartNo = new Label("Item's in cart: 0");
	
	@SuppressWarnings({ "unchecked" })
	public MarketPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		customerIDlbl.setWrapText(true);
		customerIDlbl.setTextAlignment(TextAlignment.JUSTIFY);
		//create labels
		Label plblTitle = new Label("Products:");
		this.add(plblTitle, 0, 0);
		Label dlblTitle = new Label("Discounted Products:");
		this.add(dlblTitle, 1, 0);
		this.add(customerIDlbl,1, 2);
		this.add(lblInCartNo, 3,0);
		
		//image
		GridPane imggridpane = new GridPane();
		Image image = new Image("File:src/shopping-cart.png");
		imggridpane.getChildren().add(new ImageView(image));
		this.add(imggridpane, 2,0);
		
		//add to cart button
		this.add(btnAddCart,0,2);
		
		//normal list
		plist.setCellFactory(lv -> new ListCell<Product>() {
		    @Override
		    public void updateItem(Product item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            String text = item.getDescription()+", PRICE: "+ item.getUnitPrice() ; // get text from item
		            setText(text);
		        }
		    }
		    
		});
		plist.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				dlist.getSelectionModel().select(-1);
				}});
		this.add(plist,0,1);
		
		//discounted list
		dlist.setCellFactory(lv -> new ListCell<DiscountProduct>() {
		    @Override
		    public void updateItem(DiscountProduct item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            String text = item.getDescription()+", PRICE: "+ item.getUnitPrice()+"(-"+item.getDiscountRate()*100+"%)" ; // get text from item
		            setText(text);
		        }
		    }
		    
		});
		dlist.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				plist.getSelectionModel().select(-1);
				}});
		this.add(dlist,1,1);
	}
	
	//method to attach the add button handler
	public void addToCartHandler(EventHandler<ActionEvent> handler) {
			btnAddCart.setOnAction(handler);
		}
	
	public Product getSelectedItem(){
		if (plist.getSelectionModel().getSelectedIndex()>=0){
			return (Product) plist.getSelectionModel().getSelectedItem();
		}
		else if (dlist.getSelectionModel().getSelectedIndex()>=0){
			DiscountProduct dp = (DiscountProduct) dlist.getSelectionModel().getSelectedItem();
			Product returnp = new Product();
			returnp.setDescription(dp.getDescription());
			returnp.setProductCode(dp.getProductCode());
			returnp.setUnitPrice(dp.getUnitPrice());
			return returnp;
		}
		else{
			return null;
		}

	}
	
	public void addProductToPList (Product p){
		plist.getItems().add(p);
	}
	public void addProductToDList (DiscountProduct d){
		dlist.getItems().add(d);
	}
	
	public void changeCustomerIDlbl(String idhere){
		customerIDlbl.setText("Cart will be saved upon closure. Customer ID:"+idhere);
	}
	
	public void setCartSizeLbl (Cart cart){
		lblInCartNo.setText("Items in Cart: "+cart.numberOfOrders());

	}
	
}
