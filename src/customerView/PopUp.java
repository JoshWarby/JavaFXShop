package customerView;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class PopUp {
   
    
public static void display(String lbl)
{
	Stage popupwindow=new Stage();
	      
	popupwindow.initModality(Modality.APPLICATION_MODAL);
	popupwindow.setTitle("Cart Message");
	      
	      
	Label label1= new Label(lbl);
	      
	     
	Button button1= new Button("Close");
	     
	     
	button1.setOnAction(e -> popupwindow.close());
	     
	     
	
	VBox layout= new VBox(10);
	     
	      
	layout.getChildren().addAll(label1, button1);
	      
	layout.setAlignment(Pos.CENTER);
	      
	Scene scene1= new Scene(layout, 400, 200);
	      
	popupwindow.setScene(scene1);
	      
	popupwindow.showAndWait();
       
}

}
