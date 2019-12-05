import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

	public class PostQuizUI  {
	    
		
		
	    public Scene getScene() {
	        Label QID = new Label("Enter Quiz ID: ");
	        TextField Qid = new TextField();
	      //  QID.setLabelFor(Qid); 
	        Label QN = new Label("Enter Quiz Name: ");
	        TextField Qn = new TextField();
	       // QN.setLabelFor(Qn);
	        Label QINFO = new Label("Enter Quiz Info");
	        TextField Qi = new TextField();
	       // QINFO.setLabelFor(Qi);
	        
	        TextField Question1 = new TextField("");
	        Question1.setPromptText("Insert Question 1");
	        
	        TextField Question2 = new TextField("");
	        Question2.setPromptText("Insert Question 2");
	        TextField Question3 = new TextField("");
	        Question3.setPromptText("Insert Question 3");
	        TextField Question4 = new TextField("");
	        Question4.setPromptText("Insert Question 4");
	        TextField Question5 = new TextField("");
	        Question5.setPromptText("Insert Question 5");

	        TextField Ans1 = new TextField("");
	        Ans1.setPromptText("Insert Answer 1");
	        TextField Ans2 = new TextField("");
	        Ans2.setPromptText("Insert Answer 2");
	        TextField Ans3 = new TextField("");
	        Ans3.setPromptText("Insert Answer 3");
	        TextField Ans4 = new TextField("");
	        Ans4.setPromptText("Insert Answer 4");
	        TextField Ans5 = new TextField("");
	        Ans5.setPromptText("Insert Answer 5");
	        
	        TextField o1a = new TextField("");
	        o1a.setPromptText("Insert Option a for 1");
	       
	        TextField o1b = new TextField("");
	        o1b.setPromptText("Insert Option b for 1");
	     
	        TextField o1c = new TextField("");
	        o1c.setPromptText("Insert Option c for 1");
	        
	        TextField o2a = new TextField("");
	        o2a.setPromptText("Insert Option a for 2");
	        
	        TextField o2b = new TextField("");
	        o2b.setPromptText("Insert Option b for 2");
	        
	        TextField o2c = new TextField("");
	        o2c.setPromptText("Insert Option c for 2");
	        
	        TextField o3a = new TextField("");
	        o3a.setPromptText("Insert Option a for 3");
	        
	        TextField o3b = new TextField("");
	        o3b.setPromptText("Insert Option b for 3");
	        
	        TextField o3c = new TextField("");
	        o3c.setPromptText("Insert Option c for 3");
	        
	        TextField o4a = new TextField("");
	        o4a.setPromptText("Insert Option a for 4");
	        
	        TextField o4b = new TextField("");
	        o4b.setPromptText("Insert Option b for 4");
	        
	        TextField o4c = new TextField("");
	        o4c.setPromptText("Insert Option c for 4");
	        
	        TextField o5a = new TextField("");
	        o5a.setPromptText("Insert Option a for 5");
	        
	        TextField o5b = new TextField("");
	        o5b.setPromptText("Insert Option b for 5");
	        
	        TextField o5c = new TextField("");
	        o5c.setPromptText("Insert Option c for 5");
	        
	        
	        
	        //Label Note =new Label("Enter a text file here with Questions with each upto 7 options. The first options should be answer \n [NOTE: The student will not be shown the first option is the answer, also it will appear differently to all students] ");
	        Label Status = new Label("Waiting for Upload");
	        //FileChooser fileChooser = new FileChooser();
	        
	        
	        Button button = new Button("Post Quiz");
	       
	        
	        Question1.setPrefWidth(800);
	        //Question1.setSpacing(2);
	        

	        TilePane r = new TilePane(); 
	  //      r.getChildren().add(menuBar);
	        r.getChildren().add(QID);
	        r.getChildren().add(Qid);
	        r.getChildren().add(QN);
	        r.getChildren().add(Qn);
	        r.getChildren().add(QINFO);
	        r.getChildren().add(Qi);
	      //  r.getChildren().add(Note);
	        r.getChildren().add(Question1);
	        r.getChildren().add(Ans1);
	        r.getChildren().add(o1a);
	        r.getChildren().add(o1b);
	        r.getChildren().add(o1c);
	        
	        r.getChildren().add(Question2);
	        r.getChildren().add(Ans2);
	        r.getChildren().add(o2a);
	        r.getChildren().add(o2b);
	        r.getChildren().add(o2c);
	        
	        r.getChildren().add(Question3);
	        r.getChildren().add(Ans3);
	        r.getChildren().add(o3a);
	        r.getChildren().add(o3b);
	        r.getChildren().add(o3c);
	        
	        r.getChildren().add(Question4);
	        r.getChildren().add(Ans4);
	        r.getChildren().add(o4a);
	        r.getChildren().add(o4b);
	        r.getChildren().add(o4c);
	        
	        r.getChildren().add(Question5);
	        r.getChildren().add(Ans5);
	        r.getChildren().add(o5a);
	        r.getChildren().add(o5b);
	        r.getChildren().add(o5c);
	        
	        r.getChildren().add(Status);
	        
	      
	        VBox vBox = new VBox(button);
	        r.getChildren().add(vBox);
	        Scene scene = new Scene(r,600,450);

	     //   this.getChildren().add(label2);
	        
	       // scene.addLabel(QID);Qid,QN,Qn,QINFO,Qi,Note,
	        
	        button.setOnAction(e -> {
	    //        File selectedFile = fileChooser.showOpenDialog(primaryStage);
	            System.out.println("now");
	            
	            DataManager d = new DataManager();
	            PostQuizControl o = new PostQuizControl(d);
	           
	            QuizData qd = new QuizData();
	            
	            Course course = Driver.getProfControl().getCurrentCourse();
	            
	            //int C = course.courseID;
	            
	            qd.CourseID = course.courseID;
	            qd.QuizDescription = Qi.getText();
	            qd.QuizID = Qid.getText();
	            qd.QuizName = Qn.getText();
	            
	            qd.Q1 = Question1.getText();
	            qd.Q2 = Question2.getText();
	            qd.Q3 = Question3.getText();
	            qd.Q4 = Question4.getText();
	            qd.Q5 = Question5.getText();
	            
	            qd.A1 = Ans1.getText();
	            qd.A2 = Ans2.getText();
	            qd.A3 = Ans3.getText();
	            qd.A4 = Ans4.getText();
	            qd.A5 = Ans5.getText();
	            
	            qd.O1a = o1a.getText();
	            qd.O1b = o1b.getText();
	            qd.O1c = o1c.getText();
	            
	            qd.O2a = o2a.getText();
	            qd.O2b = o2b.getText();
	            qd.O2c = o2c.getText();
	            
	            System.out.println(qd.O2a);
	            
	            qd.O3a = o3a.getText();
	            qd.O3b = o3b.getText();
	            qd.O3c = o3c.getText();
	            
	            qd.O4a = o4a.getText();
	            qd.O4b = o4b.getText();
	            qd.O4c = o4c.getText();
	            
	            qd.O5a = o5a.getText();
	            qd.O5b = o5b.getText();
	            qd.O5c = o5c.getText();
	            
	            o.setQuizValue(qd);
	            
	        });
	        
	        return scene;
	    }
	}
	
