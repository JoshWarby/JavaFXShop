package view;
import java.util.Observable;
import java.util.Observer;

import controller.CustomerController;
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
import model.Cart;
import model.Order;

public class CartItemPane extends HBox implements Observer {

	//accessible throughout the class
	private Button plusBtn, minusBtn;
	private Label numberField;
	private Label nameField;

	public CartItemPane(Order order, Cart cart,Label totalCost) {
		//set the style for this pane 
		//this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//this.getStyleClass().add("counter-pane");

		String itemName = order.getProduct().getDescription();
		totalCost.setText(Integer.toString(cart.getTotalCost()));
		
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
                totalCost.setText(Integer.toString(cart.getTotalCost()));
            }
            
        });

		//---------------Minus Button---------------------
		minusBtn = new Button("-");
		minusBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                order.decreaseQuantity();
                numberField.setText("  "+Integer.toString(order.getQuantity())+"  ");;
                if (order.getQuantity() == 0){
                	cart.removeOrder(order);
                	hideAll();
                }
                totalCost.setText(Integer.toString(cart.getTotalCost()));
                CustomerController.marketPaneCartNo();
            }
        });

		//add nodes to the scene graph for this pane
		this.getChildren().addAll(nameField,minusBtn, numberField, plusBtn);

	}


	
	
	public void hideAll(){
		this.getChildren().remove(0, this.getChildren().size());
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}