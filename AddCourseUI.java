import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class AddCourseUI {
AddCourseControl controller = new AddCourseControl();
	
	TextField textField1 = new TextField("type course name here");
	TextField textField2 = new TextField("type course description here");
	TextField textField3 = new TextField("type course number here");
	TextField textField4 = new TextField("type the ID of the course's professor here");
	Text heading = new Text("Create Course");
	Text boxTitle3 = new Text("Course name:");
	Text boxTitle2 = new Text("Course description:");
	Text boxTitle1 = new Text("Course Number:");
	Text boxTitle4 = new Text("Course Prpfessor:");
	
	
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
		
		root.getChildren().add(boxTitle4);
		root.getChildren().add(textField4);
		
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
				confirm = controller.handleAddCourse(this.textField1.getText(), this.textField2.getText(), this.textField3.getText(), this.textField4.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (confirm) 
				heading = new Text("Succes!");
			else
				heading = new Text("Failed - Make sure the course number is unique and the professor's ID is correct");
			
			
        } 
}
