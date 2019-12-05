import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class CourseUseCaseUI {
	DataManager dm = new DataManager();
	Text message = new Text("Select a Use Case");
	Button viewAssignmentsButton = new Button("View Assignments");
	Button takeQuizButton = new Button("Take a Quiz");
	Button viewGrades = new Button("View Grades");
	Button viewNotification = new Button("View Notification");
	
	
	Button goBackButton = new Button("Back");
	
    
    public CourseUseCaseUI() {

    }
    
    public Scene getScene() {
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		root.getChildren().add(viewAssignmentsButton);
		viewAssignmentsButton.setOnAction(selectViewAssignments);
		root.getChildren().add(takeQuizButton);
		takeQuizButton.setOnAction(completeQuiz);
		root.getChildren().add(viewGrades);
		root.getChildren().add(viewNotification);
	    	viewNotification.setOnAction(viewNotificationEvent->{
			ViewNotificationsControl VNC = new ViewNotificationsControl(dm);
			LoginControl LC = new LoginControl(dm);
			ViewNotificationsUI VNU = new ViewNotificationsUI(VNC, LC);
			try {
				Driver.changeScene(VNU.handleViewRequest(), 800, 700);
			} catch (LoginException e) {
				e.printStackTrace();
			}
		});
		root.getChildren().add(goBackButton);
		goBackButton.setOnAction(goBack);
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    EventHandler<ActionEvent> selectViewAssignments = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	ViewAssignmentControl viewAssignmentControl = new ViewAssignmentControl(dm);
        	ViewAssignmentUI viewAssignmentUI = new ViewAssignmentUI(viewAssignmentControl);
        	Driver.changeScene(viewAssignmentUI.getScene(), 250, 250);
            
        } 
    }; 
    
    EventHandler<ActionEvent> completeQuiz = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	CompleteQuizUI completeQuizUI = new CompleteQuizUI();
        	Driver.changeScene(completeQuizUI.getScene(),250,1000);
            
        } 
    }; 
    
    EventHandler<ActionEvent> goBack = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            Driver.goBack();
        } 
    }; 
}
