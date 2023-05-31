/*
    This is the computerTableModel class,
    it holds information relevant to creating a table for the browse products screen.
 */

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class ComputerTableModel extends AbstractTableModel {
    private ArrayList<Device> deviceList;

    // Constructor to initialize the ComputerTableModel with a list of devices
    public ComputerTableModel(ArrayList<Device> devices) {
        setDeviceList(devices);
    }

    // Override the getColumnCount() method to specify the number of columns in the table
    @Override
    public int getColumnCount() {
        return 6;
    }

    // Override the getRowCount() method to specify the number of rows in the table
    @Override
    public int getRowCount() {
        return deviceList.size();
    }

    // Override the getColumnName() method to specify the column names based on the column index
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Category";
            case 1 -> "Type";
            case 2 -> "ID";
            case 3 -> "Brand";
            case 4 -> "CPU Family";
            case 5 -> "Price($)";
            default -> null;
        };
    }

    // Override the getValueAt() method to retrieve the value at a specific row and column in the table
    @Override
    public Object getValueAt(int row, int col) {
        if (row < deviceList.size()) {
            return switch (col) {
                case 0 -> deviceList.get(row).getCategory();
                case 1 -> deviceList.get(row).getType();
                case 2 -> deviceList.get(row).getID();
                case 3 -> deviceList.get(row).getBrand();
                case 4 -> deviceList.get(row).getCPU();
                case 5 -> deviceList.get(row).getPrice();
                default -> null;
            };
        }
        return null;
    }

    // Method to set the list of devices
    public void setDeviceList(ArrayList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    // Method to delete a row from the table
    public void deleteRow(int row) {
        if (deviceList.size() > 0) {
            deviceList.remove(row);
            fireTableRowsDeleted(row, row);
            DatabaseFileReader.setAllItems(deviceList);
        }
    }

    // Method to add a new row to the table
    public void addRow(Device itemToAdd) {
        deviceList.add(itemToAdd);
        fireTableDataChanged();
        DatabaseFileReader.setAllItems(deviceList);
    }
}