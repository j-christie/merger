import java.util.Stack;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Driver extends Application {
   private static Stack<Scene> backList = new Stack<Scene>();

   public static Stage stage;
   public static DataManager dm = new DataManager();

   private static LoginControl loginControl= new LoginControl(dm);
   private static LoginUI loginUI = new LoginUI(loginControl);

   private static CourseSelectionControl courseControl = new CourseSelectionControl(dm,loginControl);
   private static CourseSelectionUI courseUI = new CourseSelectionUI(courseControl);

   private static AdminUI adminUI = new AdminUI();

   private static ProfControl profControl = new ProfControl(dm,loginControl);
   private static ProfUI profUI = new ProfUI(profControl);

   private static TAControl taControl = new TAControl(dm,loginControl);
   private static TAUI taUI = new TAUI(taControl);



   @Override public void start(Stage stage) {
		  this.stage = stage;
		  Scene firstScene = loginUI.getScene();
		  backList.push(firstScene);
	      stage.setTitle("Sample Application");
	      stage.setWidth(250);
	      stage.setHeight(250);
	      stage.setScene(firstScene);
	      stage.show();
	   }

   public static void main(String args[]){
      launch(args);
   }

   public static void changeScene(Scene s,double w, double h) {
	   backList.push(s);
	   stage.setScene(s);
	   stage.setWidth(w);
	   stage.setHeight(h);
	   stage.close();
	   stage.show();
   }

   public static void goBack() {
	   backList.pop();
	   stage.setScene(backList.peek());
	   stage.setWidth(250);
	   stage.setHeight(250);
	   stage.close();
	   stage.show();
   }

   public static LoginControl getLoginControl() {
	   return loginControl;
   }

   public static LoginUI getLoginUI() {
	   return loginUI;
   }

   public static CourseSelectionControl getCourseControl() {
	   return courseControl;
   }

   public static CourseSelectionUI getCourseUI() {
	   return courseUI;
   }

   public static ProfUI getProfUI() {
	   return profUI;
   }

   public static ProfControl getProfControl() {
	   return profControl;
   }

   public static TAUI getTAUI() {
	   return taUI;
   }

   public static TAControl getTAControl() {
	   return taControl;
   }

   public static AdminUI getAdminUI() {
	   return adminUI;
   }

   public static DataManager getDM() {
	   return dm;
   }


}
