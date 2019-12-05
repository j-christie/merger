import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ViewAssignmentControl {

	private DataManager dm;
	private Assignment currentAssignment;
	
	public ViewAssignmentControl(DataManager dm) {
		this.dm = dm;
	}
	
	public ArrayList<Assignment> handleViewAssignments() {
		ArrayList<Assignment> a = new ArrayList<Assignment>();
		UserAccount acc = Driver.getLoginControl().getUser();
		System.out.println(acc);
		if(acc.getClass() == StudentAccount.class) {
			Course c = Driver.getCourseControl().getCurrentCourse();
			a = dm.getAssignmentByCourse(c.courseID);
			System.out.println("List: " + a);
		}
		return a;
	}
	
	public void downloadAssignment() throws IOException {
		InputStream initialStream = currentAssignment.assignmentDocument;
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			 
			    String name = "Assignments/" + currentAssignment.assignmentName + " - " +  Driver.getCourseControl().getCurrentCourse().courseName + ".txt";
			    
			    File newDir = new File("Assignments");
			    newDir.mkdir();
			    
			    File targetFile = new File(name);
			    
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
	}
	
	public Assignment getCurrentAssignment() {
		return currentAssignment;
	}
	
	public void setCurrentAssignment(Assignment a) {
		currentAssignment = a;
	}
	
}
