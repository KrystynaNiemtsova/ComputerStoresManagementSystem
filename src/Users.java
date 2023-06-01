/*
    This is the user class.
    It holds the information about each user.
 */
public class Users {
    String username;
    String password;
    Boolean isManager;

    // Constructor for the Users class
    public Users(String username, String password, String position) {
        setUsername(username);
        setPassword(password);
        setManager(position);
    }

    // Another constructor for the Users class
    public Users(String username, String password, boolean manager) {
        setUsername(username);
        setPassword(password);
        setManager(manager);
    }

    // Method to authenticate the login credentials
    public boolean AuthenticateLogin(String currentUsername, String currentPassword) {
        return currentUsername.equals(username) && currentPassword.equals(password);
    }

    // Getter for the manager status
    public Boolean getManager() {
        return isManager;
    }

    // Setter for the manager status
    public void setManager(String position) {
        this.isManager = position.equals("Manager");
    }

    // Setter for the manager status
    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    // Getter for teh username
    public String getUsername() {
        return username;
    }

    // Setter for the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for the password
    public String getPassword() {
        return password;
    }

    // Setter for the password
    public void setPassword(String password) {
        this.password = password;
    }
}