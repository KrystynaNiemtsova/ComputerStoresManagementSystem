public class Laptop extends DesktopPC {
    private float screenSize;
    public Laptop(String category, String type, String ID, String brand, String CPU, int memorySize, int SSD,
                  float ScreenSize, float price) {
        super(category, type, ID, brand, CPU, memorySize, SSD, price);
        setScreenSize(screenSize);
    }
    public float getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
}
