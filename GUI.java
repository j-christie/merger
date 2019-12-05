import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
         
public class GUI extends Application { 
   public static Stage stage;
   
   @Override 
   public void start(Stage stage) {
	  this.stage = stage;
	  Scene1 s1 = new Scene1();
      stage.setTitle("Sample Application"); 
      stage.setScene(s1.getScene()); 
      stage.show(); 
   }   
   public static void main(String args[]){ 
      launch(args); 
   } 
   
   public static void changeScene(Scene s) {
	   stage.setScene(s);
	   stage.close();
	   stage.show();
   }
   

} 
