import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * After user hit the button from courseUI and that event will directly link to 'handleRequest()'.
 * @author YufeiChen
 */
public class ViewNotificationsUI {
	
	private ViewNotificationsControl control;
	private LoginControl lControl;
	private CourseSelectionControl csc;
	
	public ViewNotificationsUI(ViewNotificationsControl control, LoginControl lControl) {
		this.control = control;
		this.lControl = lControl;
	}
	
	//USE THIS METHOD TO GET THE SCENE
	public Scene handleViewRequest() throws LoginException{
		if (!checkLogin()) {
			throw new LoginException("Not logged in");
		}
		return getScene(control.getNotifications(csc.getCurrentCourse().courseID));
	}
	
	//login verification
	public boolean checkLogin(){
		if((lControl.getUser()!= null)&&(lControl.getUser().getClass() == StudentAccount.class)) {
			return true;
		}
		return false;
	}
	
	//use to handle the notification list back from database and display it
	public Scene getScene(ArrayList<Notification> list) {
	//	Stage notificationStage = new Stage();
	//	notificationStage.setTitle("Notifications");
		FlowPane fPane;
		if (list == null) {
			Text noContent = new Text("There is no notifications.");
			fPane = new FlowPane(noContent);
			Scene S1 = new Scene(fPane);
			return S1;
		//	notificationStage.setScene(S1);
		//	notificationStage.show();
		}else {
			ObservableList<Notification> listData = FXCollections.observableArrayList();
			
			for (int i = 0; i < list.size(); i++) {
				listData.add(list.get(i));
			}
			
			
			BorderPane root = new BorderPane();
			ListView<Notification> listView = new ListView<Notification>();
			listView.setItems(listData);
			listView.setCellFactory(new Callback<ListView<Notification>, ListCell<Notification>>() {
				@Override
				public ListCell<Notification> call(ListView<Notification> param) {
					return new vorListCell();
				}
			});
			
			Button back = new Button();
			back.setOnAction(new EventHandler<ActionEvent>() { 
		        public void handle(ActionEvent e) 
		        { 
		            Driver.goBack();
		        } 
			} );
			
			
			root.setCenter(listView);
			root.setRight(back);
			Scene S2 = new Scene(root, 900, 600);
			return S2;
		//	notificationStage.setScene(S2);
		//	notificationStage.show();
			
		}
	}
	
	
	//Set up cell
	static class vorListCell extends ListCell<Notification>{
		protected void updateItem(Notification arg0, boolean arg1) {
	        super.updateItem(arg0, arg1);
	
			if(arg0 == null) {
	            this.setText("");
	        }else {
	            this.setText("NotificationType: "+arg0.NotificationType+"\n"+arg0.description);
	        }
		}
	}
	
	

}

