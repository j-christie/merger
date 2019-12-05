import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class ViewAssignmentUI {
	ViewAssignmentControl control;
	
	Text message = new Text("Select An Assignment");
	ArrayList<Button> buttonList = new ArrayList<Button>();
    ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    
    
    Text title = new Text("Assignment Name");
    Text document = new Text("Assignment Text");
    Text dueDate = new Text("Due Date");
    Text reminder = new Text("");
    Button download = new Button("Download");
    
    Button back2 = new Button("Back");
    Button back = new Button("Back");
	
    
    public ViewAssignmentUI(ViewAssignmentControl control) {
    	this.control = control;
    }
    
    public Scene getScene() {
    	getAssignments();
    	
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		for(int i=0;i<buttonList.size();i++) {
			root.getChildren().add(buttonList.get(i));
		}
		for(int i=0;i<buttonList.size();i++) {
			buttonList.get(i).setOnAction(viewAnAssignment);
		}
		root.getChildren().add(back);
		back.setOnAction(goBack);
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    private Scene getScene2() {
    	System.out.println("Test 2: " + document.getText());
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(title);
		root.getChildren().add(dueDate);
		root.getChildren().add(download);
		download.setOnAction(downloadAssignment);
		root.getChildren().add(reminder);
		root.getChildren().add(back2);
		back2.setOnAction(goBack);
		Scene s = new Scene(root);
		
		
		return s;
    }
    
    EventHandler<ActionEvent> viewAnAssignment = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	for(int i=0;i<buttonList.size();i++) {
        		if(buttonList.get(i).isHover()) {
    				control.setCurrentAssignment(assignmentList.get(i));
    			}
        	}
        	title.setText(control.getCurrentAssignment().assignmentName);        	
            dueDate.setText(control.getCurrentAssignment().dateDue);
            System.out.println("Test 1: " + document.getText());
            Driver.changeScene(getScene2(),250,250);
            
        } 
    }; 
    EventHandler<ActionEvent> goBack = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            Driver.goBack();
        } 
    }; 
    
    EventHandler<ActionEvent> downloadAssignment = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            try {
				control.downloadAssignment();
				reminder.setText("Assignment Downloaded");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				reminder.setText("Assignment Download Failed");
			}
        } 
    }; 
    
    public void getAssignments() {
    	assignmentList = control.handleViewAssignments();
    	for(int i=0;i<assignmentList.size();i++) {
    		String b = assignmentList.get(i).assignmentName;
    		buttonList.add(new Button(b));
    	}
    }
}
