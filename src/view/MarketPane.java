package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

public class MarketPane extends GridPane{
	
	public MarketPane (){
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//create labels
		Label lblTitle = new Label("This is MarketPane Tab");
		this.add(lblTitle, 0, 0);
		
		//create list
		ObservableList<String> seasonList = FXCollections.<String>observableArrayList("Item 1", "Item 2", "Item 3", "Item 4");
		ListView<String> seasons = new ListView<>(seasonList);
		this.add(seasons, 1, 1);
	}

}
