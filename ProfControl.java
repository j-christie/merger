import java.util.ArrayList;

public class ProfControl {
	private DataManager dm;
	private LoginControl login;
	private Course currentCourse;
	
	public ProfControl(DataManager dm, LoginControl login) {
		this.dm = dm;
		this.login = login;
	}
	
	public ArrayList<Course> getProfCourses() {
		ArrayList<Course> c = null;
		UserAccount acc = login.getUser();
		System.out.println(acc);
		if(acc.getClass() == ProfessorAccount.class) {
			c = dm.getCoursesForProf(acc.id);
		}
		
		return c;
		
	}
	
	public void setCurrentCourse(Course c) {
		this.currentCourse = c;
	}
	
	public Course getCurrentCourse() {
		return currentCourse;
	}
}
