/*This class runs the code */

import java.io.File;
public class Main {
    public static void main(String[] args) {
        // Creating a new instance of DatabaseFileReader to read the file "computers.txt"
        new DatabaseFileReader(new File("computers.txt"));

        // Setting user information for the LoginDialog
        setUserInformation();

        // Creating a new instance of LoginScreen
        new LoginScreen();
    }

    // Method to set user information in the LoginDialog
    private static void setUserInformation() {
        // Setting users for the LoginDialog with their usernames, passwords, and roles
        LoginDialog.setUsers("p1", "p1", "Salesperson");
        LoginDialog.setUsers("p2", "p2", "Salesperson");
        LoginDialog.setUsers("p3", "p3", "Salesperson");
        LoginDialog.setUsers("m1", "m1", "Manager");
        LoginDialog.setUsers("m2", "m2", "Manager");
    }
}