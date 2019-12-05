import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * After user hit the button from courseUI and that event will directly link to 'handleRequest()'.
 * @author YufeiChen
 */
public class EditNotificationsUI {
	
	private EditNotificationControl control;
	private LoginControl lControl;
	
	public EditNotificationsUI(EditNotificationControl control, LoginControl lControl) {
		this.control = control;
		this.lControl = lControl;
	}
	
	//USE THIS METHOD TO GET THE SCENE
	public Scene handleRequest() throws LoginException{
		/*if (!checkLogin()) {
			throw new LoginException("Not logged in");
		}*/
		return getScene(control.getNotifications(/*lControl.getUser().id*/"1"));
	}
	
	//login verification
	public boolean checkLogin(){
		if((lControl.getUser()!= null)&&(lControl.getUser().getClass() == ProfessorAccount.class)) {
			return true;
		}
		return false;
	}
	
	//use to handle the notification list back from database and display it
	public Scene getScene(ArrayList<Notification> list) {
		Button edit = new Button("EDIT");
		edit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) 
	        { 
	            
	        } 
		});
		
		FlowPane fPane;
		if (list == null) {
			Text noContent = new Text("There is no notifications.");
			fPane = new FlowPane(noContent);
			Scene S1 = new Scene(fPane);
			return S1;
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
			
		}
	}
	
	
	//Set up cell
	static class vorListCell extends ListCell<Notification>{
		
		protected void updateItem(Notification arg0, boolean arg1) {
			DataManager dm= new DataManager();
			EditNotificationControl EControl = new EditNotificationControl(dm);
			Stage S1 = new Stage();
			Label L1 = new Label("PREVIOUS DESCRIPTION: ");
			TextField TF1 = new TextField();
			Button delete = new Button("DELETE THIS NOTIFICATION");
			Button update = new Button("UPDATE");
			
	        super.updateItem(arg0, arg1);
	
			if(arg0 == null) {
	            this.setText("");
	        }else {
	            this.setText("NotificationType: "+arg0.NotificationType+"\n"+arg0.description);
	            this.setOnMouseClicked(eventCLICK->{
	                System.out.println("CLICK!");
	                Text T1 = new Text(arg0.description);
	                
	                delete.setOnAction(eventDEL->{
	                	boolean result = EControl.DeleteNotification(arg0.NotificationID);
	                	S1.close();
	                	if(result) {
	                		T1.setText("Deleted");
	                		VBox s = new VBox(T1);
	                		Scene SC = new Scene(s);
	                		S1.setScene(SC);
	                		S1.show();
	                	}else {
	                		T1.setText("Delete Failed");
	                		VBox s = new VBox(T1);
	                		Scene SC = new Scene(s);
	                		S1.setScene(SC);
	                		S1.show();
	                	}
	                	
	                });
	                
	                update.setOnAction(eventUPD->{
	                	boolean result = EControl.UpdateNotification(arg0.NotificationID, arg0.description);
	                	if(result) {
	                		T1.setText("Updated");
	                		VBox s = new VBox(T1);
	                		Scene SC = new Scene(s);
	                		S1.setScene(SC);
	                		S1.show();
	                	}else {
	                		T1.setText("Update Failed");
	                		VBox s = new VBox(T1);
	                		Scene SC = new Scene(s);
	                		S1.setScene(SC);
	                		S1.show();
	                	}
	                });
	                
	                VBox v1 = new VBox(L1, T1, TF1, update, delete);
	                Scene Sc = new Scene(v1, 400, 200);
	                S1.setScene(Sc);
	                S1.show();
	            });
	        }
		}
	}
	
	

}

