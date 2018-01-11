package view;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CartItemPane extends HBox implements Observer {

	//accessible throughout the class
	private Button plusBtn, minusBtn;
	private Label numberField;
	private Label nameField;

	public CartItemPane() {
		//set the style for this pane 
		//this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//this.getStyleClass().add("counter-pane");

		String itemName = "ITEM NAME    ";
		
		nameField = new Label(itemName);
		// ------------Number Field-----------------------
		numberField = new Label("0");

		//---------------Plus Button---------------------
		plusBtn = new Button("+");

		//---------------Minus Button---------------------
		minusBtn = new Button("-");

		//add nodes to the scene graph for this pane
		this.getChildren().addAll(nameField,minusBtn, numberField, plusBtn);

	}
	public CartItemPane(String in) {
		//set the style for this pane 
		//this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//this.getStyleClass().add("counter-pane");

		String itemName = in;
		
		nameField = new Label(itemName);
		// ------------Number Field-----------------------
		numberField = new Label("0");

		//---------------Plus Button---------------------
		plusBtn = new Button("+");

		//---------------Minus Button---------------------
		minusBtn = new Button("-");

		//add nodes to the scene graph for this pane
		this.getChildren().addAll(nameField,minusBtn, numberField, plusBtn);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}