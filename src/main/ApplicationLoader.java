package main;

import controller.CustomerController;
//import controller.DiceGameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.*;

//import controller and view
//import model.DiceGameEngine;
import view.ShoppingRootPane;

public class ApplicationLoader extends Application{

	private ShoppingRootPane view;


	@Override
	public void init() {
		//create model and view and pass their references to the controller
		Customer cu = new Customer();
		view = new ShoppingRootPane();
		new CustomerController(view, cu);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(500); //sets min width and height for the stage window
		stage.setMinHeight(300);
		stage.setTitle("Let's Shop");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
