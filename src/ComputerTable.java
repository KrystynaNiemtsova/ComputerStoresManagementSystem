import javax.swing.*;
import java.util.ArrayList;

public class ComputerTable extends JFrame {
    static JTabbedPane tabbedPane = new JTabbedPane();
    static ArrayList<String> categories;
    static ArrayList<String> types;
    private JPanel browseProducts = new JPanel();
    protected static JFrame frame;
    static ComputerTableModel computerTable;
    private static JTable table;
    UpdateProducts products;
}
