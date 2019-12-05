import java.io.IOException;
import java.util.ArrayList;

public class CompleteQuizControl {
	
	QuizResultData q;
	int choice;
	
	private DataManager dm;
	//private LoginControl login;
	
	public CompleteQuizControl(DataManager dm) {
		this.dm = dm;
		//this.login = login;
	}
	
	public QuizData getQuiz(int QuizID) throws IOException {
		QuizData c = null;
		//UserAccount acc = login.getUser();
		//System.out.println(acc);
		//if(acc.getClass() == StudentAccount.class) {
			//System.out.println(acc.id);
			//c = dm.getCoursesForStudent(acc.id);
		//}
		
		c = dm.getQuiz(QuizID);
		
		//System.out.println(dm.q.quizID);
		
		return c;
		
	}

	public void setpassResult(QuizResultData qrd) {
		// TODO Auto-generated method stub
		q = qrd;
		resulttodb(q);
	}
	
	public void resulttodb(QuizResultData q2)
	{
		dm.insertQuizResult(q.QuizID, q.StudentID, q.Score);
	}
	
	public ArrayList<String> getQuizList(int course) {
		
		ArrayList<String> cs = dm.GetQuizInfo(course);
		
		return cs;
	}

	public void setChoice(String text) {
		choice = Integer.parseInt(text);
		
	}

	public int getChoice()
	{
		return choice; 
	}
	
	
	
	//public String getStudentID()
	//{
		////DataManager dm = new DataManager();
		//LoginControl lc = new LoginControl(dm);
		//UserAccount UA = lc.getUser();
		//String SID = UA.id;
		//String SID = "3572159";
		//return SID;
	//}
	
	//public int PassResult() 
	//{
	//	Controller lvc = new Controller();
	//	int r = lvc.passres();
	//	System.out.println("Score >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+r);
	//return r;
	//}
	
}
