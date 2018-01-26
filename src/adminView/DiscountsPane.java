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


public class DiscountsPane extends GridPane{

	protected ListView plist = new ListView();
	protected ListView dlist = new ListView();
    private Button btnChangeDiscount = new Button("Change Discount");
    private TextField txtID, txtDiscount;
	
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
		            String text = item.getProductCode()+" : "+item.getDescription()+", PRICE: "+ item.getUnitPrice() ; // get text from item
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
		            String text = item.getProductCode()+" : "+item.getDescription()+", PRICE: "+ item.getUnitPrice()+"(-"+item.getDiscountRate()*100+"%)" ; // get text from item
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
	
	public void clearProducts(){
		plist.getItems().clear();
		dlist.getItems().clear();
	}
	
	public String getEnteredPCode(){
		return txtID.getText();
	}
	public double getEnteredDRate(){
		double rate;
		String enteredpercentage = txtDiscount.getText();
		rate = (double)Integer.parseInt(enteredpercentage)/(double)100;
		return rate;
	}
	
	
	
	public void addProductToPList (Product p){
		plist.getItems().add(p);
	}
	public void addProductToDList (DiscountProduct d){
		dlist.getItems().add(d);
	}

	public void addDiscountHandler(EventHandler<ActionEvent> handler) {
		btnChangeDiscount.setOnAction(handler);
		
	}

}
