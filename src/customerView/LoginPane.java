package customerView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

//import model.Player;

public class LoginPane extends GridPane {

//	private ComboBox<Player> cboOpponent;
	private TextField txtSurname, txtFirstName;
	private Button btnPlay;

	public LoginPane() {
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//create labels
		Label lblTitle = new Label("Login Details :");
		Label lblFirstName = new Label("First name: ");
		Label lblSurname = new Label("Last name: ");


		//setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();
		
		//initialise submit button
		btnPlay = new Button("Submit");

		//add controls and labels to container
		this.add(lblTitle, 0, 0);

		this.add(lblFirstName, 0, 1);
		this.add(txtFirstName, 1, 1);

		this.add(lblSurname, 0, 2);
		this.add(txtSurname, 1, 2);
			
		this.add(new HBox(), 0, 3);
		this.add(btnPlay, 1, 3);
	}
	
	
	public String getFNameInput() {
		return txtFirstName.getText();
	}
	
	public String getLNameInput() {
		return txtSurname.getText();
	}
	
	//method to attach the play button handler
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		btnPlay.setOnAction(handler);
	}

}
