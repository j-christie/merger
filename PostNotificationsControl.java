import java.util.ArrayList;

public class PostNotificationsControl {
	DataManager dm;
	
	public PostNotificationsControl(DataManager dm) {
		this.dm = dm;
	}
	
	public ArrayList<String> getCourseID(String id) {
		return dm.getCourseByPName(id);
	}
	
	public boolean AddNotification(String NotID, String CourseID, String Description, char courseType) {
		boolean result = dm.PostNotification(NotID, CourseID, Description, courseType);
		return result;
	}
}
