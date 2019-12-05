import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class CourseSelectionUI {
	DataManager dm = new DataManager();
    CourseSelectionControl control;

	Text message = new Text("Select a Course");

    ArrayList<Button> buttonList = new ArrayList<Button>();
    Button awardsButton = new Button("View Awards");
	Button profileButton = new Button("Update Profile Information");
    ArrayList<Course> courseList = new ArrayList<Course>();

    public CourseSelectionUI(CourseSelectionControl control) {
    	this.control = control;
    }

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
		root.getChildren().add(awardsButton);
		root.getChildren().add(profileButton);
      	profileButton.setOnAction(profileEvent);
		Scene s = new Scene(root);


		return s;
	}

    public void getCourses() {
    	courseList = control.getStudentCourses();
    	System.out.println(courseList.size());
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
            CourseUseCaseUI UseCaseUI = new CourseUseCaseUI();
            Driver.changeScene(UseCaseUI.getScene(),250,250);
        }
    };

	EventHandler<ActionEvent> profileEvent = new EventHandler<ActionEvent>() {
	public void handle(ActionEvent e)
	{
		System.out.println("Change profile info");
		ChangeProfileInformationControl control = new ChangeProfileInformationControl(Driver.getDM(), Driver.getLoginControl());
		ChangeProfileInformationUI profileUI = new ChangeProfileInformationUI(control);
		Driver.changeScene(profileUI.getScene(),250,250);
	}
	};

}
