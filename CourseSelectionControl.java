import java.util.ArrayList;

public class CourseSelectionControl {
	
	private DataManager dm;
	private LoginControl login;
	private Course currentCourse;
	
	public CourseSelectionControl(DataManager dm, LoginControl login) {
		this.dm = dm;
		this.login = login;
	}
	
	public ArrayList<Course> getStudentCourses() {
		ArrayList<Course> c = null;
		UserAccount acc = login.getUser();
		System.out.println(acc);
		if(acc.getClass() == StudentAccount.class) {
			c = dm.getCoursesForStudent(acc.id);
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

