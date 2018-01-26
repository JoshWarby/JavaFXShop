package adminView;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import model.Product;

public class RewardsPane extends GridPane{

	private TextField txtID = new TextField();
	private Button btnaddID = new Button("Add to scheme");
	private Button btnremoveID = new Button("Remove from scheme");
	
	@SuppressWarnings("rawtypes")
	ListView plist = new ListView();	
	@SuppressWarnings("unchecked")
	public RewardsPane() {
	this.setPadding(new Insets(80, 80, 80, 80));
	this.setVgap(15);
	this.setHgap(20);
	this.setAlignment(Pos.CENTER);
	
	//list
		plist.setCellFactory(lv -> new ListCell<Product>() {
		    @Override
		    public void updateItem(Product item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            String text = item.getProductCode()+" : "+item.getDescription() ; // get text from item
			            setText(text);
			        }
		        }
		    }
		);
	
	//adding
		
	this.add(txtID, 0, 1);
	this.add(btnaddID, 1, 1);
	this.add(btnremoveID, 2, 1);
	this.add(plist,0,0);
	
	
}
	public String getEnteredPCode(){
		return txtID.getText();
		}
	public void addAddRewardHandler(EventHandler<ActionEvent> handler) {
		btnaddID.setOnAction(handler);
		
	}
	public void addRemoveRewardHandler(EventHandler<ActionEvent> handler) {
		btnremoveID.setOnAction(handler);
		
	}
	public void addProduct(Product p){
		plist.getItems().add(p);
	}
	public void clearProducts() {
		plist.getItems().clear();
		
	}
}