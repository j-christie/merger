
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PostNotificationsUI {
	static String ID = "10000";
	private PostNotificationsControl pControl;
	private LoginControl lControl;
	
	public PostNotificationsUI(PostNotificationsControl pControl, LoginControl lControl) {
		this.pControl = pControl;
		this.lControl = lControl;
	}

	public Scene processAddition() {
		Text fail = new Text("You are not logged in yet");
		Scene S1;
		VBox root;
		if(!checkLogin()) {
			root = new VBox(fail);
			S1 = new Scene(root);
			return S1;
		}
		TextArea tBox = new TextArea();
		Label L1 = new Label("Notification Description: ");
		ArrayList<String> list = pControl.getCourseID(lControl.getUser().id);
		
        ChoiceBox cb = new ChoiceBox();
        for(int i = 0;i<list.size();i++) {
        	cb.getItems().add(list.get(i));
        }
        cb.getSelectionModel().selectFirst();
        
        ChoiceBox cb2 = new ChoiceBox();
        char[] Types = {'a', 'b','c'};
        for(int i = 0;i<Types.length;i++) {
        	cb2.getItems().add(Types[i]);
        }
        cb2.getSelectionModel().selectFirst();
        
        Button done = new Button("Post new Notification");
        done.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String CourseID = (String)cb.getSelectionModel().getSelectedItem();
				char CourseType = (char)cb2.getSelectionModel().getSelectedItem();
				String NotificationID = IDGen();
				String Description = tBox.getText();
				handleResult(pControl.AddNotification(NotificationID, CourseID, Description, CourseType));
			}
		});
        
        Button back = new Button();
		back.setOnAction(new EventHandler<ActionEvent>() { 
	        public void handle(ActionEvent e) 
	        { 
	            Driver.goBack();
	        } 
		} );
        
        root =new VBox(L1, tBox, cb, cb2, done, back);
        S1 = new Scene(root);
        return S1;
	}
	
	
	//login verification
	public boolean checkLogin(){
		if((lControl.getUser()!= null)&&(lControl.getUser().getClass() == ProfessorAccount.class)) {
			return true;
		}
		return false;
	}
	
	//Notification ID generation
	public String IDGen() {
		int cur = (int)(Math.random()*100000);
		return cur+1+"";
	}
	
	public void handleResult(boolean result) {
		Stage S1 = new Stage();
		Text T1;
		VBox v;
		if(result) {
			T1 = new Text("Notification Posted");
			
		}else {
			T1 = new Text("Notification post failed");
		}
		v= new VBox(T1);
		Scene Sc1 = new Scene(v);
		S1.setHeight(100);
		S1.setWidth(220);
		S1.setScene(Sc1);
		S1.show();
	}
	
}
