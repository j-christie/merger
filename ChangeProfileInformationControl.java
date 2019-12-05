import java.sql.SQLException;

class ChangeProfileInformationControl {
    DataManager dm;
    LoginControl login;

    public ChangeProfileInformationControl( DataManager dm, LoginControl login) {
        this.dm = dm;
        this.login = login;
    }

    public void handleNewProfileInformation(String nickname, String hometown, String hostname) throws LoginException, SQLException{
        UserAccount acc = login.getUser();

        if (acc != null && acc.getClass() == StudentAccount.class) {
            dm.updateProfileInformation(acc.id, nickname, hometown, hostname);
        }
        else {
            throw new LoginException("You must login before creating a profile");
        }
    }
}
