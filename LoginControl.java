public class LoginControl {

    private static DataManager dm = new DataManager();// see below
    private static UserAccount acc;//made this static so it didn't need to be passed around once it is made once you can just make a new ones as needed


    public LoginControl(DataManager dM) {
    	dm = dM;
    }
    
    public LoginControl() {
    }
    
    public UserAccount getUser() {
        return acc;
    }

    public UserAccount login(String accountType, String id, String pass) {
        if (accountType.equals("Student")) {
            acc = dm.getStudentAccount(id, pass);
        } else if (accountType.equals("Admin")) {
            acc = dm.getAdminAccount(id, pass);
        } else if (accountType.equals("TA")) {
            acc = dm.getTAAccount(id, pass);
        } else if (accountType.equals("Professor")) {
            acc = dm.getProfessorAccount(id, pass);
        } 
        else {
            System.out.println("Error: " + accountType + " is not a valid account type");
        }
        return acc;
    }
}
