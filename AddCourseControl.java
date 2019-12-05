
public class AddCourseControl {
	
	public boolean handleAddCourse(String name, String desc, String courseID, String prof) {
		return Driver.getDM().addCourse(courseID, name, desc, prof);
	}

}
