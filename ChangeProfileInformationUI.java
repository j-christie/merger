import java.util.Scanner;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class ChangeProfileInformationUI {
    ChangeProfileInformationControl control;
    TextField nickname = new TextField("Nickname");
    TextField hometown = new TextField("Hometown");
    TextField hostname = new TextField("Hostname");
    Button back = new Button("Back");
    Button b = new Button("Submit");
    Text message = new Text("Enter new profile information");

    public ChangeProfileInformationUI(ChangeProfileInformationControl control) {
        this.control = control;
    }

    public void getNewProfileInformation() throws LoginException, SQLException{
        String nickname = this.nickname.getText();
        String hometown = this.hometown.getText();
        String hostname = this.hostname.getText();

        control.handleNewProfileInformation(nickname, hometown, hostname);
    }

    public Scene getScene() {
        TilePane root = new TilePane();
        root.setHgap(5);
        root.setVgap(5);
        b.setOnAction(updateEvent);
        back.setOnAction(backEvent);
        root.getChildren().add(back);
        root.getChildren().add(nickname);
        root.getChildren().add(hometown);
        root.getChildren().add(hostname);
        root.getChildren().add(b);
        root.getChildren().add(message);
        Scene s = new Scene(root);

        return s;
    }

    EventHandler<ActionEvent> updateEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
                getNewProfileInformation();
            }
            catch (Exception err) {
                message.setText(err.getMessage());
                System.err.println(err);
            }
        }
    };


    EventHandler<ActionEvent> backEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            Driver.goBack();
        }
    };

}
