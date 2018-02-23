package customerView;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import customerController.CustomerController;
import model.Cart;
import model.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class CartItemPane extends HBox implements Observer {

	//accessible throughout the class
	private Button plusBtn, minusBtn;
	private Label numberField;
	private Label nameField;
	private DecimalFormat df=new DecimalFormat("0.00");
	public CartItemPane(Order order, Cart cart,Label totalCost) {
		//set the style for this pane 
		//this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//this.getStyleClass().add("counter-pane");

		String itemName = order.getProduct().getDescription();
		totalCost.setText("Total Cost £"+df.format(((double)cart.getTotalCost()/100)));
		
		nameField = new Label(itemName+"  ");
		// ------------Number Field-----------------------
		numberField = new Label("  "+Integer.toString(order.getQuantity())+"  ");

		//---------------Plus Button---------------------
		plusBtn = new Button("+");
		plusBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                order.increaseQuantity();
                numberField.setText("  "+Integer.toString(order.getQuantity())+"  ");
                totalCost.setText("Total Cost £"+df.format(((double)cart.getTotalCost()/100)));
            }
            
        });

		//---------------Minus Button---------------------
		minusBtn = new Button("-");
		minusBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                order.decreaseQuantity();
                numberField.setText("  "+Double.toString(order.getQuantity())+"  ");;
                if (order.getQuantity() == 0){
                	cart.removeOrder(order);
                	hideAll();
                }
                totalCost.setText("Total Cost £"+df.format(((double)cart.getTotalCost()/100)));
                CustomerController.marketPaneCartNo();
            }
        });

		//add nodes to the scene graph for this pane
		this.getChildren().addAll(nameField,minusBtn, numberField, plusBtn);
		

	}

	/**
	 * This method deletes the product from the cart pane leaving only the message "Removed"
	 */
	private void hideAll(){
		this.getChildren().remove(0, this.getChildren().size());
		numberField.setText("Removed");
		this.getChildren().add(numberField);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}