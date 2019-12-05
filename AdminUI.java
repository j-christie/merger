import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class AdminUI {
	DataManager dm = new DataManager();

	Text message = new Text("Select a Course");

	Button addCourse = new Button("add Course");
    Button createAccount = new Button("Create user account");
    Button addStudentToCourse = new Button("Add Student To Course");




    public Scene getScene() {

		addCourse.setOnAction(addEvent);

		createAccount.setOnAction(createEvent);

		addStudentToCourse.setOnAction(addStudentEvent);

    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);
		root.getChildren().add(addCourse);
		root.getChildren().add(createAccount);
		root.getChildren().add(addStudentToCourse);
		Scene s = new Scene(root);

		return s;
	}

	EventHandler<ActionEvent> createEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			System.out.println("Switch to create account scene");
			CreateAccountControl createAccountControl = new CreateAccountControl(Driver.getDM(), Driver.getLoginControl());
			CreateAccountUI createAccountUI = new CreateAccountUI(createAccountControl);
			Driver.changeScene(createAccountUI.getScene(),250,250);
		}
	};

	EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			AddCourseUI uI = new AddCourseUI();
			Driver.changeScene(uI.getScene(), 500, 500);
		}
	};

	EventHandler<ActionEvent> addStudentEvent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			System.out.println("Add Student To Course");
		}
	};
}
