import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.text.*;


public class ViewAwardsUI {
	static ViewAwardsControl controller = new ViewAwardsControl();
	

	

	
    public static Scene getScene() {
    	

    	Text title= new Text("Awards Recieved:");
    	title.setFont(new Font(20));
    	
    	Text awardList = new Text(controller.handleViewAwards());
    	awardList.setFont(new Font(13));
    	
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(title);
		root.getChildren().add(awardList);
		Scene s = new Scene(root);
		
		
		return s;
	}
}
