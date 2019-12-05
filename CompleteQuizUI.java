import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
public class CompleteQuizUI{
	
	public QuizData QuizD;
	 RadioButton q1a = new RadioButton("1a");
     RadioButton q1b = new RadioButton("1b");
     RadioButton q1c = new RadioButton("1c");
     RadioButton q1d = new RadioButton("1d");
     ToggleGroup one = new ToggleGroup();
     Label QuizInfo = new Label("Select one of the Following are the Available Quiz here ");
     Label Qdata = new Label("");
     TextField QSelect = new TextField();
     Label QuizName = new Label("Name");
     Label QuizDescription = new Label("Description");
     Label Question1 = new Label("");
     Label Question2 = new Label("");
     Label Question3 = new Label("");
     Label Question4 = new Label("");
     Label Question5 = new Label("");
     Label ch = new Label("");
     RadioButton q2a = new RadioButton("2a");
     RadioButton q2b = new RadioButton("2b");
     RadioButton q2c = new RadioButton("2c");
     RadioButton q2d = new RadioButton("2d");
     ToggleGroup two = new ToggleGroup();
     RadioButton q3a = new RadioButton("3a");
     RadioButton q3b = new RadioButton("3b");
     RadioButton q3c = new RadioButton("3c");
     RadioButton q3d = new RadioButton("3d");
     ToggleGroup three = new ToggleGroup();
     
     RadioButton q4a = new RadioButton("4a");
     RadioButton q4b = new RadioButton("4b");
     RadioButton q4c = new RadioButton("4c");
     RadioButton q4d = new RadioButton("4d");
     ToggleGroup four = new ToggleGroup();
     
     RadioButton q5a = new RadioButton("5a");
     RadioButton q5b = new RadioButton("5b");
     RadioButton q5c = new RadioButton("5c");
     RadioButton q5d = new RadioButton("5d");
     ToggleGroup five = new ToggleGroup();
     
     Label Grade = new Label("");
     Button button = new Button("StartQuiz");
     Button sub  = new Button("Submit");

    public Scene getScene() 
    {
   
        q1a.setToggleGroup(one);
        q1b.setToggleGroup(one);
        q1c.setToggleGroup(one);
        q1d.setToggleGroup(one);
        
        
        q2a.setToggleGroup(two);
        q2b.setToggleGroup(two);
        q2c.setToggleGroup(two);
        q2d.setToggleGroup(two);
        
       
        q3a.setToggleGroup(three);
        q3b.setToggleGroup(three);
        q3c.setToggleGroup(three);
        q3d.setToggleGroup(three);
       
        q4a.setToggleGroup(four);
        q4b.setToggleGroup(four);
        q4c.setToggleGroup(four);
        q4d.setToggleGroup(four);
        
        
        q5a.setToggleGroup(five);
        q5b.setToggleGroup(five);
        q5c.setToggleGroup(five);
        q5d.setToggleGroup(five);
        
        
        
       //// TextField Ans1 = new TextField("");
       // TextField Ans2 = new TextField("");
       // TextField Ans3 = new TextField("");
       // TextField Ans4 = new TextField("");
       // TextField Ans5 = new TextField("");
        
       
       // int Course = 2;
    	
        Course course = Driver.getCourseControl().getCurrentCourse();
        
        int C = Integer.parseInt(course.courseID);		 
        		 
    	DataManager d = new DataManager();
    	CompleteQuizControl vqlc = new CompleteQuizControl(d); 
    	ArrayList<String> ID = vqlc.getQuizList(C);
    	String str[] = new String[ID.size()]; 
    	for (int j = 0; j < ID.size(); j++) 
    		str[j] = ID.get(j); 
    	String q = Arrays.deepToString(str);
    	Qdata.setText(q);

        TilePane r = new TilePane(); 
        r.getChildren().add(QuizInfo);
        r.getChildren().add(Qdata);
        r.getChildren().add(QSelect);
        r.getChildren().add(button);
        r.getChildren().add(QuizName);
        r.getChildren().add(QuizDescription);
        //r.getChildren().add(button);
        r.getChildren().add(Question1);
        r.getChildren().add(q1a);
        r.getChildren().add(q1b);
        r.getChildren().add(q1c);
        r.getChildren().add(q1d);
      //  r.getChildren().add(Ans1);
       // Ans1.setVisible(false);
        r.getChildren().add(Question2);
        r.getChildren().add(q2a);
        r.getChildren().add(q2b);
        r.getChildren().add(q2c);
        r.getChildren().add(q2d);	
      //  r.getChildren().add(Ans2);
        //Ans2.setVisible(false);
        r.getChildren().add(Question3);
        r.getChildren().add(q3a);
        r.getChildren().add(q3b);
        r.getChildren().add(q3c);
        r.getChildren().add(q3d);
       // r.getChildren().add(Ans3);
       // Ans3.setVisible(false);
        r.getChildren().add(Question4);
        r.getChildren().add(q4a);
        r.getChildren().add(q4b);
        r.getChildren().add(q4c);
        r.getChildren().add(q4d);
      //  r.getChildren().add(Ans4);
       // Ans4.setVisible(false);
        r.getChildren().add(Question5);
        r.getChildren().add(q5a);
        r.getChildren().add(q5b);
        r.getChildren().add(q5c);
        r.getChildren().add(q5d);
      //  r.getChildren().add(Ans5);
      //  Ans5.setVisible(false);
        r.getChildren().add(Grade);
        Grade.setVisible(false);
        r.getChildren().add(sub);
        sub.setVisible(true);
        q1a.setVisible(false);
        q1b.setVisible(false);
        q1c.setVisible(false);
        q1d.setVisible(false);
        q2a.setVisible(false);
        q2b.setVisible(false);
        q2c.setVisible(false);
        q2d.setVisible(false);
        q3a.setVisible(false);
        q3b.setVisible(false);
        q3c.setVisible(false);
        q3d.setVisible(false);
        q4a.setVisible(false);
        q4b.setVisible(false);
        q4c.setVisible(false);
        q4d.setVisible(false);
        q5a.setVisible(false);
        q5b.setVisible(false);
        q5c.setVisible(false);
        q5d.setVisible(false);
        
        Scene scene = new Scene(r,300,500);
              
        button.setOnAction
        (e -> 
        	{
        		DataManager ds = new DataManager();
        		CompleteQuizControl v = new CompleteQuizControl(ds);
        		v.setChoice(QSelect.getText());
        		
        		int x = v.getChoice();
        		//int y = Integer.pa
        		ch.setText(Integer.toString(x));
        		
        		CompleteQuizControl qc = new CompleteQuizControl(ds);
        		try 
        		{
					QuizD = qc.getQuiz(x);
					QuizName.setText("Name: "+QuizD.QuizName);
					QuizDescription.setText("Description: "+QuizD.QuizDescription);
				//	System.out.println(QuizD.Q1);
					Question1.setText(QuizD.Q1);
					Question2.setText(QuizD.Q2);
					Question3.setText(QuizD.Q3);
					Question4.setText(QuizD.Q4);
					Question5.setText(QuizD.Q5);
					
					int random = (int)(Math.random() * 4 + 1);
					if (random == 4)
					{
						q1a.setText(QuizD.O1c);
						q1b.setText(QuizD.O1a);
						q1c.setText(QuizD.O1b);
						q1d.setText(QuizD.A1);	
					}
					else if (random == 3)
					{
						q1a.setText(QuizD.O1c);
						q1b.setText(QuizD.O1b);
						q1c.setText(QuizD.A1);
						q1d.setText(QuizD.O1a);	
					}
					else if (random == 2)
					{
						q1a.setText(QuizD.O1c);
						q1b.setText(QuizD.A1);
						q1c.setText(QuizD.O1b);
						q1d.setText(QuizD.O1a);	
					}
					else if (random == 1)
					{
						q1a.setText(QuizD.A1);
						q1b.setText(QuizD.O1b);
						q1c.setText(QuizD.O1a);
						q1d.setText(QuizD.O1c);	
					}
					
					int random2 = (int)(Math.random() * 4 + 1);
					if (random2 == 4)
					{
						q2a.setText(QuizD.O2c);
						q2b.setText(QuizD.O2a);
						q2c.setText(QuizD.O2b);
						q2d.setText(QuizD.A2);	
					}
					else if (random2 == 3)
					{
						q2a.setText(QuizD.O2c);
						q2b.setText(QuizD.O2b);
						q2c.setText(QuizD.A2);
						q2d.setText(QuizD.O2a);	
					}
					else if (random2 == 2)
					{
						q2a.setText(QuizD.O2c);
						q2b.setText(QuizD.A2);
						q2c.setText(QuizD.O2b);
						q2d.setText(QuizD.O2a);	
					}
					else if (random2 == 1)
					{
						q2a.setText(QuizD.A2);
						q2b.setText(QuizD.O2b);
						q2c.setText(QuizD.O2a);
						q2d.setText(QuizD.O2c);	
					}
					
					int random3 = (int)(Math.random() * 4 + 1);
					if (random3 == 4)
					{
						q3a.setText(QuizD.O3c);
						q3b.setText(QuizD.O3a);
						q3c.setText(QuizD.O3b);
						q3d.setText(QuizD.A3);	
					}
					else if (random3 == 3)
					{
						q3a.setText(QuizD.O3c);
						q3b.setText(QuizD.O3b);
						q3c.setText(QuizD.A3);
						q3d.setText(QuizD.O3a);	
					}
					else if (random3 == 2)
					{
						q3a.setText(QuizD.O3c);
						q3b.setText(QuizD.A3);
						q3c.setText(QuizD.O3b);
						q3d.setText(QuizD.O3a);	
					}
					else if (random3 == 1)
					{
						q3a.setText(QuizD.A3);
						q3b.setText(QuizD.O3b);
						q3c.setText(QuizD.O3a);
						q3d.setText(QuizD.O3c);	
					}
					
					int random4 = (int)(Math.random() * 4 + 1);
					if (random4 == 4)
					{
						q4a.setText(QuizD.O4c);
						q4b.setText(QuizD.O4a);
						q4c.setText(QuizD.O4b);
						q4d.setText(QuizD.A4);	
					}
					else if (random4 == 3)
					{
						q4a.setText(QuizD.O4c);
						q4b.setText(QuizD.O4b);
						q4c.setText(QuizD.A4);
						q4d.setText(QuizD.O4a);	
					}
					else if (random4 == 2)
					{
						q4a.setText(QuizD.O4c);
						q4b.setText(QuizD.A4);
						q4c.setText(QuizD.O4b);
						q4d.setText(QuizD.O4a);	
					}
					else if (random4 == 1)
					{
						q4a.setText(QuizD.A4);
						q4b.setText(QuizD.O4b);
						q4c.setText(QuizD.O4a);
						q4d.setText(QuizD.O4c);	
					}
					
					int random5 = (int)(Math.random() * 4 + 1);
					if (random5 == 4)
					{
						q5a.setText(QuizD.O5c);
						q5b.setText(QuizD.O5a);
						q5c.setText(QuizD.O5b);
						q5d.setText(QuizD.A5);	
					}
					else if (random == 3)
					{
						q5a.setText(QuizD.O5c);
						q5b.setText(QuizD.O5b);
						q5c.setText(QuizD.A5);
						q5d.setText(QuizD.O5a);	
					}
					else if (random == 2)
					{
						q5a.setText(QuizD.O5c);
						q5b.setText(QuizD.A5);
						q5c.setText(QuizD.O5b);
						q5d.setText(QuizD.O5a);	
					}
					else if (random == 1)
					{
						q5a.setText(QuizD.A5);
						q5b.setText(QuizD.O5b);
						q5c.setText(QuizD.O5a);
						q5d.setText(QuizD.O5c);	
					}
					
					q1a.setVisible(true);
			        q1b.setVisible(true);
			        q1c.setVisible(true);
			        q1d.setVisible(true);
			        q2a.setVisible(true);
			        q2b.setVisible(true);
			        q2c.setVisible(true);
			        q2d.setVisible(true);
			        q3a.setVisible(true);
			        q3b.setVisible(true);
			        q3c.setVisible(true);
			        q3d.setVisible(true);
			        q4a.setVisible(true);
			        q4b.setVisible(true);
			        q4c.setVisible(true);
			        q4d.setVisible(true);
			        q5a.setVisible(true);
			        q5b.setVisible(true);
			        q5c.setVisible(true);
			        q5d.setVisible(true);
				//	Ans1.setVisible(true);
					//Ans1.setText(QuizD.A1);
				//	Ans2.setVisible(true);
					//Ans2.setText(QuizD.A2);
				//	Ans3.setVisible(true);
					//Ans3.setText(QuizD.A3);
				//	Ans4.setVisible(true);
					///Ans4.setText(QuizD.A4);
				//	Ans5.setVisible(true);
					//Ans5.setText(QuizD.A5);
					
					//sub.setVisible(true);
					//System.out.println("QuizName: " + QuizD.QuizName);
					//System.out.println("QuizDescription: " + QuizD.QuizDescription);
				} 
        		catch (IOException e1) 
        		{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        );
        
        sub.setOnAction
        (e -> 
        	{
        		DataManager ds = new DataManager();
        		
        		 Grade.setVisible(true);
        		int score = 0;
        		
        		RadioButton selectedRadioButton = (RadioButton) one.getSelectedToggle();
        		String C1 = selectedRadioButton.getText();
        		System.out.println(C1);
        		System.out.println(QuizD.A1);
        		if(C1.equals(QuizD.A1))
        		{	score++;
        			System.out.println("this1");
        		}
        		RadioButton selectedRadioButton2 = (RadioButton) two.getSelectedToggle();
        		String C2 = selectedRadioButton2.getText();
        		System.out.println(C2);
        		System.out.println(QuizD.A2);
        		if(C2.equals(QuizD.A2))
        		{	score++;
        		System.out.println("this2");
        		}
        		RadioButton selectedRadioButton3 = (RadioButton) three.getSelectedToggle();
        		String C3 = selectedRadioButton3.getText();
        		System.out.println(C3);
        		System.out.println(QuizD.A3);
        		if(C3.equals(QuizD.A3)) {
        			score++;
        			System.out.println("this3");
        		}
        		RadioButton selectedRadioButton4 = (RadioButton) four.getSelectedToggle();
        		String C4 = selectedRadioButton4.getText();
        		System.out.println(C4);
        		System.out.println(QuizD.A4);
        		if(C4.equals(QuizD.A4)) {
        			score++;
        			System.out.println("thi4s");
        		}
        		RadioButton selectedRadioButton5 = (RadioButton) five.getSelectedToggle();
        		String C5 = selectedRadioButton5.getText();
        		System.out.println(C5);
        		System.out.println(QuizD.A5);
        		if(C5.equals(QuizD.A5)) {
        			score++;
        			System.out.println("this5");
        		}
        		String rs = Integer.toString(score);
        		Grade.setText("Grade: "+rs);
        		
				CompleteQuizControl forStore = new CompleteQuizControl(ds);
				String QID = QSelect.getText();
				//String StudentID = Driver
				QuizResultData qrd = new QuizResultData();
				qrd.QuizID = Integer.parseInt(QID);
				UserAccount currentUser = Driver.getLoginControl().getUser();
				qrd.StudentID = currentUser.id;
				qrd.Score = score;
				forStore.setpassResult(qrd);
				//forStore.resulttodb();
        	}
        );
        
        
        
        return scene;
	
    }  
}
