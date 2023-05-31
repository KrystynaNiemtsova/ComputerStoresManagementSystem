/*
    This class enables the rows to be filtered by type.
 */

import javax.swing.*;

public class typeFilter extends RowFilter {
    private String type;
    private String category;

    // Constructor for the TypeFilter Class
    public typeFilter(String type, String category) {
        setType(type);
        setCategory(category);
    }

    // Overriding the include() method of the RowFilter class
    @Override
    public boolean include (Entry entry) {
        if (entry.getStringValue(0).equals(category)) {
            return entry.getStringValue(1).equals(type);
        }
        return false;
    }

    // Setter for the type
    public void setType(String type) {
        this.type = type;
    }

    // Setter for the category
    public void setCategory(String category) {
        this.category = category;
    }
}