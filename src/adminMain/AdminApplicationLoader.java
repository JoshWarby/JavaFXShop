package adminMain;

import model.*;
import adminController.AdminController;
import adminView.AdminRootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminApplicationLoader extends Application{

	private AdminRootPane view;
	private AdminController ac;


	@Override
	public void init() {
		//create model and view and pass their references to the controller
		view = new AdminRootPane();
		ac = new AdminController(view);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(900); //sets min width and height for the stage window
		stage.setMinHeight(200);
		stage.setTitle("Admin Program");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		//populate list
		launch(args);
	}
}
