import java.io.File;

public class PostQuizControl {
	
	QuizData Quizdata;

	DataManager dm;
	
	public PostQuizControl(DataManager d) {
		dm = d;
	}

	//public int getQuiz(File selectedFile, String quizID, String quizName, String quizInfo) {		
		
		//int x = dm.StoreQuiz(selectedFile,quizID,quizName,quizInfo);
		
	//	return x;
	//}

	public void setQuizValue(QuizData qd) {
		// TODO Auto-generated method stub
		
		System.out.println("asdad");
		
		Quizdata = qd;
		dm.StoreQuiz(Quizdata);
	}

}
