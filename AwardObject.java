import java.sql.*;
import java.util.*;


public class AwardObject {
	public ArrayList<String> names = new ArrayList<String>();
	public ArrayList<String> descriptions = new ArrayList<String>();
	private DataManager dM = new DataManager();
	private LoginControl lC = new LoginControl();
	
	public AwardObject() {
		
		ResultSet rs = dM.getAwards(lC.getUser().id);

		try {
			while (rs.next()) {
				names.add(rs.getString(2));
				descriptions.add(rs.getString(3));
			}
		}
		
		catch (SQLException e) {
			names.clear();
			descriptions.clear();
			System.err.println(e);
		}
	}	
}
