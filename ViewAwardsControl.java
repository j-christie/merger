
public class ViewAwardsControl {

	
	public String handleViewAwards() {
		String awardList = "\n";
		AwardObject awardObj = new AwardObject();
		int i = 0;
		if (awardObj.names.isEmpty()) {
			awardList += "Sorry, no awards at this time ¯\\_(ツ)_/¯";
		}
		else {
			while(awardObj.names.get(i)!=null) {
				awardList += awardObj.names.get(i);
				awardList += "\t\t";
				awardList += awardObj.descriptions.get(i);
				awardList += "\n";			
			}
		}	
		return awardList;
	}
}
