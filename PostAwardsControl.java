
public class PostAwardsControl {

	
	private DataManager dM = new DataManager(); 

	public boolean handleAddAward(String name, String desc, String studID) {
		if(dM.isStudent(studID)==1)
		dM.addAward(studID, name, desc);
		else
			return false;
		return true;
	}

		
		


	
	
}
