import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class TAUseCaseUI {
	Text message = new Text("Select a Use Case");
	Button markAssignmentsButton = new Button("Mark Assignments");
	Button markQuizButton = new Button("Mark a Quiz");
	
	Button back = new Button("Back");
	
    
    public TAUseCaseUI() {

    }
    
    public Scene getScene() {
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		root.getChildren().add(markAssignmentsButton);
		markAssignmentsButton.setOnAction(markAssignments);
		root.getChildren().add(markQuizButton);
		root.getChildren().add(back);
		back.setOnAction(goBack);
		Scene s = new Scene(root);
		
		return s;
	}
    
    EventHandler<ActionEvent> markAssignments = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 

            
        } 
    }; 
    
    EventHandler<ActionEvent> goBack = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            Driver.goBack();
        } 
    }; 
}
