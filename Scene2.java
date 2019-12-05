import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class Scene2 {
	TilePane root = new TilePane();
	
	public Scene getScene2() {
		root = new TilePane();
		Button b = new Button("Scene 2");
		b.setOnAction(this::handleButtonEvent);
		root.getChildren().add(b);
		Scene s = new Scene(root);
		
		
		return s;
	}
	
	public void handleButtonEvent(ActionEvent event) {
		Button b =(Button)event.getSource();
		Scene1 s1 = new Scene1();
		System.out.println("Hello");
		GUI.changeScene(s1.getScene());
		System.out.println("GoodBye");
		
	}
}
