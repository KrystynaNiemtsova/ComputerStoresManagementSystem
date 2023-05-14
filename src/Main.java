import java.io.File;
public class Main {
    public static void main(String[] args) {
        new DatabaseFileReader(new File("computers.txt"));
        setUserInformation();
    }
    private static void setUserInformation() {
        LoginDialogScreen.setUsers("p1", "p1", "Salesperson");
        LoginDialogScreen.setUsers("p2", "p2", "Salesperson");
        LoginDialogScreen.setUsers("p3", "p3", "Salesperson");
        LoginDialogScreen.setUsers("m1", "m1", "Manager");
        LoginDialogScreen.setUsers("m2", "m2", "Manager");
    }
}