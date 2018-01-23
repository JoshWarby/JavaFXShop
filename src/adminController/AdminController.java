package adminController;

import model.*;
import adminView.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AdminController {
	
	//fields to be used throughout the class
	private AdminRootPane view;
	private ProductsPane pp;
	private Customer cu;
	public AdminController(AdminRootPane view) {
		//initialise model and view fields
		this.view = view;
		pp = view.getProductsPane();
		this.attachEventHandlers();

	}
	private void attachEventHandlers() {
		pp.addAddHandler(new AddSubmitHandler()); //attaches add button handler
		pp.addRemoveHandler(new RemoveSubmitHandler()); //attaches add button handler
	}
	private class AddSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			System.out.println("added");
		}
	}
	private class RemoveSubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			System.out.println("removed");
		}
	}
}
