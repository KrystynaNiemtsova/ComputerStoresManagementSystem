import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseFileReader {
    private static ArrayList<DesktopPC> desktopPC = new ArrayList<>();
    private static ArrayList<Laptop> laptop = new ArrayList<>();
    private static ArrayList<Tablet> tablet = new ArrayList<>();
    private static ArrayList<Device> allDevices = new ArrayList<>();
    public DatabaseFileReader(File infile) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(infile)))) {
            while (scanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                while (lineScanner.hasNext()) {
                    lineScanner.useDelimiter(",");
                    String category = lineScanner.next();
                    String type = lineScanner.next();
                    String ID = lineScanner.next();
                    String brand = lineScanner.next();
                    String CPU = lineScanner.next();

                    int memorySize;
                    int SSD;
                    float price;
                    if (category.equals("Desktop PC")) {
                        memorySize = lineScanner.nextInt();
                        SSD = lineScanner.nextInt();
                        price = lineScanner.nextFloat();
                        desktopPC.add(new DesktopPC(category, type, ID, brand, CPU, memorySize, SSD, price));
                    }
                    float screenSize;
                    if (category.equals("Laptop")) {
                        memorySize = lineScanner.nextInt();
                        SSD = lineScanner.nextInt();
                        screenSize = lineScanner.nextFloat();
                        price = lineScanner.nextFloat();
                        laptop.add(new Laptop(category, type, ID, brand, CPU, memorySize, SSD, screenSize, price));
                    }
                    if (category.equals("Tablet")) {
                        screenSize = lineScanner.nextFloat();
                        price = lineScanner.nextFloat();
                        tablet.add(new Tablet(category, type, ID, brand, CPU, screenSize, price));
                    }
                }
            }
            allDevices.addAll(desktopPC);
            allDevices.addAll(laptop);
            allDevices.addAll(tablet);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<DesktopPC> getDesktopPC() {
        return desktopPC;
    }
    public static void setDesktopPC(ArrayList<DesktopPC> desktopPC) {
        DatabaseFileReader.desktopPC = desktopPC;
    }
    public static ArrayList<Laptop> getLaptop() {
        return laptop;
    }
    public static ArrayList<Tablet> getTablet() {
        return tablet;
    }
    public static void setTablet(ArrayList<Tablet> tablet) {
        DatabaseFileReader.tablet = tablet;
    }
    public static ArrayList<Device> getAllDevices() {
        return allDevices;
    }
    public static void setAllDevices(ArrayList<Device> allDevices) {
        DatabaseFileReader.allDevices = allDevices;
    }
    public static void setLaptop(ArrayList<Laptop> laptop) {
        DatabaseFileReader.laptop = laptop;
    }
}
