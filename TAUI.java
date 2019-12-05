import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class TAUI {
	DataManager dm = new DataManager();
	TAControl control;
	
	public TAUI(TAControl control) {
		this.control = control;
	}
	
	Text message = new Text("Select a Course");
	
    ArrayList<Button> buttonList = new ArrayList<Button>();
    ArrayList<Course> courseList = new ArrayList<Course>();
    
    public Scene getScene() {
    	getCourses();
    	
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		for(int i=0;i<buttonList.size();i++) {
			root.getChildren().add(buttonList.get(i));
		}
		for(int i=0;i<buttonList.size();i++) {
			buttonList.get(i).setOnAction(selectCourse);
		}
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    public void getCourses() {
    	courseList = control.getTACourses();
    	for(int i=0;i<courseList.size();i++) {
    		String b = courseList.get(i).courseNumber + " - " + courseList.get(i).courseName;
    		buttonList.add(new Button(b));
    	}
    }
    
    EventHandler<ActionEvent> selectCourse = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	for(int i=0;i<buttonList.size();i++) {
        		if(buttonList.get(i).isHover()) {
    				control.setCurrentCourse(courseList.get(i));
    				System.out.println(control.getCurrentCourse().courseName);
    			}
        	}
            TAUseCaseUI UseCaseUI = new TAUseCaseUI();
            Driver.changeScene(UseCaseUI.getScene(),250,250);
        } 
    }; 
}
