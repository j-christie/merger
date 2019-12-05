import java.util.ArrayList;

public class EditNotificationControl {
	private DataManager dm;
	
	public EditNotificationControl(DataManager dm) {
		this.dm = dm;
	}
	
	public ArrayList<Notification> getNotifications(String profID){
		return dm.getNotificationsByID(profID);
	}
	
	public boolean DeleteNotification(String notificationID) {
		boolean result = dm.DeleteNotification(notificationID);
		return result;
	}
	
	public boolean UpdateNotification(String noteID, String description) {
		boolean result = dm.UpdateNotification(noteID, description);
		return result;
	}
	
}
