import java.util.ArrayList;

public class ViewNotificationsControl {
	private DataManager dm;
	
	public ViewNotificationsControl(DataManager dm) {
		this.dm = dm;
	}
	
	public ArrayList<Notification> getNotifications(String CourseID){
		return dm.getNotifications(CourseID);
	}
	
}
