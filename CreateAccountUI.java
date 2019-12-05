import java.util.Scanner;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class CreateAccountUI {
    CreateAccountControl control;
    TextField id = new TextField("ID");
    TextField username = new TextField("Username");
    TextField password = new TextField("Password");
    TextField type = new TextField("Account Type");
    TextField name = new TextField("Name");
    TextField address = new TextField("Address");
    TextField email = new TextField("Email");
    Button back1 = new Button("Back");
    Button back2 = new Button("Back");
    Button b1 = new Button("Submit");
    Button b2 = new Button("Create Account");
    Text message = new Text("Enter id and password to create new account");

    public CreateAccountUI(CreateAccountControl control) {
        this.control = control;
    }

    public String getType() {
        String type = this.type.getText();

        return type;
    }

    public void getAccountCreationDetails(String type) throws LoginException, SQLException {

        String id = this.id.getText();
        String username = this.username.getText();
        String password = this.password.getText();

        if (type.equals("Admin")) {
            control.createAdmin(id, username, password);
        } else if (type.equals("Professor")) {
            System.out.print("Name: ");
            String name = this.name.getText();
            control.createProfessor(id, username, password, name);
        } else if (type.equals("TA")) {
            System.out.print("Name: ");
            String name = this.name.getText();
            control.createTA(id, username, password, name);
        } else if (type.equals("Student")) {
            System.out.print("Name: ");
            String name = this.name.getText();
            System.out.print("Address: ");
            String address = this.address.getText();
            System.out.print("Email: ");
            String email = this.email.getText();
            control.createStudent(id, username, password, name, address, email);
        }

    }

    public Scene getScene() {
        TilePane root = new TilePane();
        root.setHgap(5);
        root.setVgap(5);
        b1.setOnAction(typeEvent);
        back1.setOnAction(backEvent);
        root.getChildren().add(back1);
        root.getChildren().add(type);
        root.getChildren().add(b1);
        root.getChildren().add(message);
        Scene s = new Scene(root);

        return s;
    }

    public Scene subScene(String type) {
        TilePane root = new TilePane();
        root.setHgap(5);
        root.setVgap(5);
        b2.setOnAction(e -> subEvent(type));
        back2.setOnAction(backEvent);
        root.getChildren().add(back2);
        root.getChildren().add(id);
        root.getChildren().add(username);
        root.getChildren().add(password);
        if (!type.equals("Admin")) {
            root.getChildren().add(name);
        }
        if (type.equals("Student")) {
            root.getChildren().add(address);
            root.getChildren().add(email);
        }
        root.getChildren().add(b2);
        root.getChildren().add(message);
        Scene s = new Scene(root);

        return s;
    }

    EventHandler<ActionEvent> typeEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
                String type = getType();
                Driver.changeScene(subScene(type),250,250);
            }
            catch (Exception err) {
                message.setText(err.getMessage());
                System.err.println(err);
            }
        }
    };

    private void subEvent(String type) {
        try {
            getAccountCreationDetails(type);
            System.out.println("Account Created");
            message.setText("Account Created");
        }
        catch (Exception err) {
            message.setText(err.getMessage());
            System.err.println(err);
        }
    }

    EventHandler<ActionEvent> backEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            Driver.goBack();
        }
    };
}
