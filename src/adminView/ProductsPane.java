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
import model.Order;

public class ProductsPane extends GridPane{

	protected ListView plist = new ListView();
	protected ListView dlist = new ListView();
    private Button btnAddProduct = new Button("Add Product");
    private Button btnRemoveProduct = new Button("Remove Product");
	
	public ProductsPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//buttons
		this.add(btnAddProduct,0,1);
		this.add(btnRemoveProduct,1,1);
		
		//lists
		this.add(plist,0,0);
		this.add(dlist,1,0);
				
	}

	public void addAddHandler(EventHandler<ActionEvent> handler) {
		btnAddProduct.setOnAction(handler);
		
	}

	public void addRemoveHandler(EventHandler<ActionEvent> handler) {
		btnRemoveProduct.setOnAction(handler);
		
	}
}
