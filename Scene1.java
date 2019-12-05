import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.*;
public class Scene1 {
	TilePane root = new TilePane();
	
	
	public Scene getScene() {
		root.setHgap(5);
		root.setVgap(5);	
		Button b = new Button("Scene 1");
		b.setOnAction(this::handleButtonEvent);
		root.getChildren().add(b);
		Scene s = new Scene(root);
		
		
		return s;
	}
	
	
	
	
	public void handleButtonEvent(ActionEvent event) {
		Button b =(Button)event.getSource();
		Scene2 s2 = new Scene2();
		System.out.println("Hello");
		GUI.changeScene(s2.getScene2());
		System.out.println("GoodBye");
		
	}
}
