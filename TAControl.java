import java.util.ArrayList;

public class TAControl {
	private DataManager dm;
	private LoginControl login;
	private Course currentCourse;
	
	public TAControl(DataManager dm, LoginControl login) {
		this.dm = dm;
		this.login = login;
	}
	
	public ArrayList<Course> getTACourses() {
		ArrayList<Course> c = null;
		UserAccount acc = login.getUser();
		System.out.println(acc);
		if(acc.getClass() == TAAccount.class) {
			c = dm.getCoursesForTA(acc.id);
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
