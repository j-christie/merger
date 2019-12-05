import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class PostAwardsUI {
	
	PostAwardsControl controller = new PostAwardsControl();
	
	TextField textField1 = new TextField("type award name here");
	TextField textField2 = new TextField("type award description here");
	TextField textField3 = new TextField("type student's ID here");
	Text heading = new Text("Post Award");
	Text boxTitle3 = new Text("Award name:");
	Text boxTitle2 = new Text("Award description:");
	Text boxTitle1 = new Text("Student's  ID:");
	
    public Scene getScene() {
    	

    	heading.setFont(new Font(20));
    	
    	Button submit = new Button("Submit");
		submit.setOnAction(this::submit);
    	
    	Button back = new Button("Back");
		submit.setOnAction(this::back);

    	boxTitle1.setFont(new Font(13));
    	

    	boxTitle2.setFont(new Font(13));
    	

    	boxTitle3.setFont(new Font(13));
    	    	
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(heading);
		
		root.getChildren().add(boxTitle1);
		root.getChildren().add(textField1);
		
		root.getChildren().add(boxTitle2);
		root.getChildren().add(textField2);
		
		root.getChildren().add(boxTitle3);
		root.getChildren().add(textField3);
		
		root.getChildren().add(submit);
		root.getChildren().add(back);
		
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    
    public void back(ActionEvent e) 
    { 
    	Driver.goBack();
		
    } 
    
    
        public void submit(ActionEvent e) 
        { 
        	boolean confirm = false;
			try {
				confirm = controller.handleAddAward(this.textField1.getText(), this.textField2.getText(), this.textField3.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (confirm) 
				heading = new Text("Succes!");
			else
				heading = new Text("Failed - Student does not exist");
			
			
        } 
}
