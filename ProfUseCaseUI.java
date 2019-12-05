import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class ProfUseCaseUI {
	Text message = new Text("Select a Use Case");
	Button uploadAssignmentsButton = new Button("Post Assignments");
	Button createQuizButton = new Button("Make a Quiz");
	Button giveAward = new Button("Give Award");
	Button postNotification = new Button("Post Notification");
	Button editNotification = new Button("Edit Notification");
	Button back = new Button("Back");
   	DataManager dm = new DataManager();
    public ProfUseCaseUI() {

    }
    
    public Scene getScene() {
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		root.getChildren().add(uploadAssignmentsButton);
		uploadAssignmentsButton.setOnAction(selectPostAssignments);
		root.getChildren().add(createQuizButton);
		createQuizButton.setOnAction(createQuiz);
		root.getChildren().add(giveAward);
		root.getChildren().add(postNotification);
	    	postNotification.setOnAction(postNotificationEvent->{
			PostNotificationsControl PNC = new PostNotificationsControl(dm);
			LoginControl LC = new LoginControl(dm);
			PostNotificationsUI PNU = new PostNotificationsUI(PNC, LC);
			Driver.changeScene(PNU.processAddition(), 800, 700);
		});
		root.getChildren().add(editNotification);
		editNotification.setOnAction(editNotificationEvent->{
			EditNotificationControl ENC = new EditNotificationControl(dm);
			LoginControl LC = new LoginControl(dm);
			EditNotificationsUI ENU = new EditNotificationsUI(ENC, LC);
			try {
				Driver.changeScene(ENU.handleRequest(), 800, 700);
			} catch (LoginException e) {
				e.printStackTrace();
			}
		});
		root.getChildren().add(back);
		back.setOnAction(goBack);
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    EventHandler<ActionEvent> selectPostAssignments = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	PostAssignmentControl postAssignmentControl = new PostAssignmentControl(Driver.getDM());
        	PostAssignmentUI postAssignmentUI = new PostAssignmentUI(postAssignmentControl);
        	Driver.changeScene(postAssignmentUI.getScene(), 250, 250);
            
        } 
    }; 
    
    EventHandler<ActionEvent> createQuiz = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	PostQuizUI createQuizUI = new PostQuizUI();
        	Driver.changeScene(createQuizUI.getScene(), 250, 1000); 
        } 
    }; 
    
    EventHandler<ActionEvent> goBack = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            Driver.goBack();
        } 
    }; 
}
