package customerMain;

import java.io.File;
import java.util.Scanner;

import customerController.CustomerController;
import customerView.ShoppingRootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;


public class ApplicationLoader extends Application{

	private ShoppingRootPane view;
	private Customer cu;
	private CustomerController cc;

	@Override
	public void init() {
		//create model and view and pass their references to the controller
		cu = new Customer();
		view = new ShoppingRootPane();
		cc = new CustomerController(view, cu);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(100); //sets min width and height for the stage window
		stage.setMinHeight(200);
		stage.setTitle("Let's Shop");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		//populate list
		launch(args);
	}
	
	@Override
	public void stop(){
	    System.out.println("Stage is closing");
	    cc.uponClose();
	}
}
