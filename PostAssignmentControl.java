import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostAssignmentControl {	
	DataManager dm;
	
	public PostAssignmentControl(DataManager dm) {
		this.dm = dm;
	}
	
	public int handlePostAssignment(String name, File file) throws LoginException {
		int success = 0;
		UserAccount acc = Driver.getLoginControl().getUser();
		System.out.println(acc);
		if(acc.getClass() == ProfessorAccount.class) {
			Course course = Driver.getProfControl().getCurrentCourse();
			
			success = dm.postAssignment(name,course.courseID,file);
		}
		else {
			throw new LoginException("Tryed to use a professor use case while not a professor");
		}
		return success;
		
	}
	
	
}
