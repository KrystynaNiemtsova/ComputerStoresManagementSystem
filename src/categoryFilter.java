/* This class enables the rows to be filtered by category */

import javax.swing.*;

public class categoryFilter extends RowFilter {
    private String category;

    // Constructor to initialize the category
    public categoryFilter(String category) {
        setCategory(category);
    }

    // Override the include() method to determine if a row should be included in the filter
        @Override
    public boolean include(Entry entry) {
        // Compare the value of the first column (index 0) with the category
        return entry.getStringValue(0).equals(category);
    }

    // Method to set the category
    public void setCategory(String category) {
        this.category = category;
    }
}