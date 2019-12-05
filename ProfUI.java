import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class ProfUI {
	DataManager dm = new DataManager();
	ProfControl control;
	
	public ProfUI(ProfControl control) {
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
    	courseList = control.getProfCourses();
    	for(int i=0;i<courseList.size();i++) {
    		String b = courseList.get(i).courseNumber + " - " + courseList.get(i).courseName;
    		buttonList.add(new Button(b));
    	}
    	System.out.println(buttonList.size());
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
            ProfUseCaseUI UseCaseUI = new ProfUseCaseUI();
            Driver.changeScene(UseCaseUI.getScene(),250,250);
        } 
    }; 
}
