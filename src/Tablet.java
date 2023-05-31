/*
    This class is the Tablet class.
    It is a child class of the device parent class,
    and holds information specific to tablets including screen size.
 */
public class Tablet  extends Device{
    private float screenSize;

    // Constructor for the Tablet class
    public Tablet(String category, String type, String ID, String brand, String CPU, float screenSize, float price) {
        super(category, type, ID, brand, CPU, price);
        setScreenSize(screenSize);
    }

    // Getter for the screen size
    public float getScreenSize() {
        return screenSize;
    }

    // Setter for the screen size
    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
}