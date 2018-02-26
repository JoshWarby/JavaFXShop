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

/**
 * This class is the runnable class for the admin program.
 * @author Josh
 *
 */
public class AdminApplicationLoader extends Application{

	private AdminRootPane view;
	private AdminController ac;


	@Override
	public void init() {
		//create model and view and pass their references to the controller
		view = new AdminRootPane();
		ac = new AdminController(view);
	}
	
	/**
	 * Starts the GUI
	 * @param Stage The stage of which every page will be shown upon.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setMinWidth(900); //sets min width and height for the stage window
		stage.setMinHeight(100);
		stage.setTitle("Admin Program");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		//populate list
		launch(args);
	}
}
