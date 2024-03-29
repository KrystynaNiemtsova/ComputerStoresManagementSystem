/*
    This is the login dialog screen.
    It takes care of the sales person
    login and validating their login credentials.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private static Users currentUser;
    static ArrayList<Users> users = new ArrayList<>();

    // Constructor for the LoginDialog class
    public LoginDialog(JFrame mainWindow) {
        super(mainWindow, "Sales Person Login", true);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        // ActionListener for the login button
        loginButton.addActionListener(e -> {
            int i;
            for (i = 0; i < users.size(); i++) {
                if (users.get(i).AuthenticateLogin(getUsername(), getPassword())) {
                    currentUser = new Users(users.get(i).getUsername(), users.get(i).getPassword(), users.get(i).getManager());
                    setCurrentUser(currentUser);
                    dispose();
                    mainWindow.dispose();
                    new ComputerTable();
                    break;
                } else if (i == users.size() - 1) {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Invalid username or password",
                               "Login",
                                    JOptionPane.ERROR_MESSAGE);
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });

        // ActionListener for the cancel button
        cancelButton.addActionListener(e -> dispose());

        panel.add(loginButton);
        panel.add(cancelButton);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(mainWindow);
    }

    // Method to set the users in the login dialog
    public static void setUsers(String userName, String password, String position) {
        users.add(new Users(userName, password, position));
    }

    // Getter for the username
    public String getUsername() {
        return usernameField.getText().trim();
    }

    // Getter for the password
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Getter for the current user
    public static Users getCurrentUser() {
        return currentUser;
    }

    // Setter for the current user
    public void setCurrentUser(Users currentUser) {
        LoginDialog.currentUser = currentUser;
    }
}