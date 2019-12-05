import java.sql.SQLException;

public class CreateAccountControl {
    DataManager dm;
    LoginControl login;

    public CreateAccountControl(DataManager dm, LoginControl login) {
        this.dm = dm;
        this.login = login;
    }

    public boolean isLoggedIn() {
        UserAccount user = login.getUser();
        if ((user != null) && (user.getClass() == AdminAccount.class)) {
            return true;
        } else
            return false;
    }

    public void createAdmin(String id, String username, String password) throws LoginException, SQLException {
        if (isLoggedIn())
            dm.createAdmin(id, username, password);
        else
            throw new LoginException("Login as Administrator to create an account");
    }

    public void createProfessor(String id, String username, String password, String name) throws LoginException, SQLException {
        if (isLoggedIn())
            dm.createProfessor(id, username, password, name);
        else
            throw new LoginException("Login as Administrator to create an account");
    }

    public void createTA(String id, String username, String password, String name) throws LoginException, SQLException {
        if (isLoggedIn())
            dm.createTA(id, username, password, name);
        else
            throw new LoginException("Login as Administrator to create an account");
    }

    public void createStudent(String id, String username, String password, String name, String address, String email) throws LoginException, SQLException {
        if (isLoggedIn())
            dm.createStudent(id, username, password, name, address, email);
        else
            throw new LoginException("Login as Administrator to create an account");
    }

}
