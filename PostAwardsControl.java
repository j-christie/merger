
public class PostAwardsControl {

	
	private DataManager dM = Driver.getDM(); 

	public boolean handleAddAward(String name, String desc, String studID) {
		return dM.addAward(studID, name, desc);
	}

		
		


	
	
}
