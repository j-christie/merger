	import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

	public class LoginUI {
		
		DataManager dm = new DataManager();
		CourseSelectionControl courseControl;
		
		TextField id = new TextField("ID");
		TextField password = new TextField("Password");
		TextField type = new TextField("Account Type");
		Button b = new Button("Login");
		Text message = new Text("Enter id and password to login");
	    LoginControl control;

	    public LoginUI(LoginControl control) {
	        this.control = control;
	        courseControl = new CourseSelectionControl(dm,control);
	    }

	    public String handleLogin() throws LoginException{
	        String type = this.type.getText();
	        String id = this.id.getText();
	        String password = this.password.getText();

	        UserAccount user = control.login(type, id, password);

	        if (user != null) {
	            message.setText("Login Successful");
	            return type;
	        }
	        else {
	            message.setText("Login Failed");
	            throw new LoginException("Login Exception");

	        }
	    }
	    
	    public Scene getScene() {
	    	TilePane root = new TilePane();
			root.setHgap(5);
			root.setVgap(5);	
			b.setOnAction(event);
			root.getChildren().add(id);
			root.getChildren().add(password);
			root.getChildren().add(type);
			root.getChildren().add(b);
			root.getChildren().add(message);
			Scene s = new Scene(root);
			
			
			return s;
		}
	    
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
    			try {
    				String type = handleLogin();
    				System.out.println(type);
					if(type.equals("Student")) Driver.changeScene(Driver.getCourseUI().getScene(),250,250);
					else if(type.equals("Admin")) Driver.changeScene(Driver.getAdminUI().getScene(),250,250);
					else if(type.equals("Professor")) Driver.changeScene(Driver.getProfUI().getScene(),250,250);
					else if(type.equals("TA")) Driver.changeScene(Driver.getTAUI().getScene(),250,250);
				} catch (LoginException e1) {
					e1.printStackTrace();
				}
            } 
        };
	}

