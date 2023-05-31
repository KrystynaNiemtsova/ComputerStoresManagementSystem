/*
    This class reads in the database file.
 */

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
    private static ArrayList<Device> allItems = new ArrayList<>();

    // Constructor to read the database file and populate the device lists
    public DatabaseFileReader(File infile) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(infile)))) {
            while (scanner.hasNextLine()) {
                // Read each line and parse the values using a delimiter (',')
                Scanner lineScanner = new Scanner(scanner.nextLine());
                lineScanner.useDelimiter(",");

                // Extract the information for each device category (Desktop PC, Laptop, Tablet)
                String category = lineScanner.next();
                String type = lineScanner.next();
                String ID = lineScanner.next();
                String brand = lineScanner.next();
                String CPU = lineScanner.next();

                // Process the information based on the category
                switch (category) {
                    case "Desktop PC" -> {
                        int memorySize = lineScanner.nextInt();
                        int SSD = lineScanner.nextInt();
                        float price = lineScanner.nextFloat();
                        desktopPC.add(new DesktopPC(category, type, ID, brand, CPU, memorySize, SSD, price));
                    }
                    case "Laptop" -> {
                        int memorySize = lineScanner.nextInt();
                        int SSD = lineScanner.nextInt();
                        float screenSize = lineScanner.nextFloat();
                        float price = lineScanner.nextFloat();
                        laptop.add(new Laptop(category, type, ID, brand, CPU, memorySize, SSD, screenSize, price));
                    }
                    case "Tablet" -> {
                        float screenSize = lineScanner.nextFloat();
                        float price = lineScanner.nextFloat();
                        tablet.add(new Tablet(category, type, ID, brand, CPU, screenSize, price));
                    }
                }
            }

            // Combine all devices from different categories into a single list
            allItems.addAll(desktopPC);
            allItems.addAll(laptop);
            allItems.addAll(tablet);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters for the device lists and all items list
    public static ArrayList<DesktopPC> getDesktopPC() {
        return desktopPC;
    }
    public static void setDesktopPC(ArrayList<DesktopPC> desktopPC) {
        DatabaseFileReader.desktopPC = desktopPC;
    }
    public static ArrayList<Laptop> getLaptop() {
        return laptop;
    }
    public static void setLaptop(ArrayList<Laptop> laptop) {
        DatabaseFileReader.laptop = laptop;
    }
    public static ArrayList<Tablet> getTablet() {
        return tablet;
    }
    public static void setTablet(ArrayList<Tablet> tablet) {
        DatabaseFileReader.tablet = tablet;
    }
    public static ArrayList<Device> getAllItems() {
        return allItems;
    }
    public static void setAllItems(ArrayList<Device> allItems) {
        DatabaseFileReader.allItems = allItems;
    }
}