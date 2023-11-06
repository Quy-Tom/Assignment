package CarManagement;

import CarManagement.InforCustomer;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CustomerList extends HashMap<Car, InforCustomer> {

    public static String fileBrandsName = "D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\brands.txt";

    private Map<Car, InforCustomer> listcus;
    public Scanner sc = new Scanner(System.in);

    public CustomerList() {
        listcus = new HashMap<>();
    }

    public void makeAnBill() {
        boolean x = true;
        List<Car> carList = new ArrayList<>();
        carList = readCarList("D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\cars.txt");

        System.out.println("Enter information of customer:");
        System.out.print("Input full name of customer: ");
        String name = sc.nextLine();
        System.out.print("Input address of customer: ");
        String address = sc.nextLine();
        System.out.print("Input phone number of customer: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Input gmail of customer: ");
        String gmail = sc.nextLine();
        String carID = "";

        do {
            System.out.print("Input carID: ");
            carID = sc.nextLine();
            for (Car car : carList) {
                if (carID.equals(car.getCarID())) {
                    x = false;
                }

            }
        } while (x);
        Car car = new Car(carID, null, "", "", "");

        for (Car car1 : carList) {
            if (car.getCarID().equals(car1.getCarID())) {
                car = car1;
                break;
            }
        }

        InforCustomer ic = new InforCustomer(name, address, phoneNumber, gmail, car);

        listcus.put(car, ic);
        System.out.println("A bill has been created successfully!");

    }

    public static List<Car> readCarList(String filePath) {
        List<Car> carList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carInfo = line.split(", ");
                if (carInfo.length == 5) {
                    String carID = carInfo[0].trim();
                    String brandID = carInfo[1].trim();
                    String color = carInfo[2].trim();
                    String frameID = carInfo[3].trim();
                    String engineID = carInfo[4].trim();

                    Brand b = new Brand(brandID, "", "", 0);
                    List<Brand> brandList = readBrandList("D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\brands.txt");
                    for (Brand brand : brandList) {
                        if (b.getBrandID().equals(brand.getBrandID())) {
                            b = brand;
                            break;
                        }
                    }

                    if (b == null) {
                        System.out.println("BrandID is not existed!");
                    } else {
                        Car car = new Car(carID, b, color, frameID, engineID);
                        carList.add(car);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carList;
    }

    public static List<Brand> readBrandList(String filePath) {
        List<Brand> brandList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] brandInfo = line.split(",\\s*|:\\s*");
                if (brandInfo.length == 4) {
                    String ID = brandInfo[0].trim();
                    String brand = brandInfo[1].trim();
                    String sound = brandInfo[2].trim();
                    String price = brandInfo[3].trim();
                    double priceValue = Double.parseDouble(price);

                    Brand b = new Brand(ID, brand, sound, priceValue);
                    brandList.add(b);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return brandList;
    }

    public void printListCustomer() {
        Set<Car> carSet = listcus.keySet();
        for (Car car : carSet) {
            InforCustomer inforCustomer = listcus.get(car);

            int maxWidth = 38;  // Chiều rộng tối đa của bảng

            // In dòng đầu tiên của hình chữ nhật
            printHorizontalLine(maxWidth);
            System.out.println("|                 BILL                       |");
            printHorizontalLine(maxWidth);

            // In thông tin của xe
            printTableRow("Car ID:", car.getCarID(), maxWidth);
            System.out.println("|  Brand:" + car.getBrand().toString() + "|");
            printTableRow("Color:", car.getColor(), maxWidth);
            printTableRow("Frame ID:", car.getFrameID(), maxWidth);
            printTableRow("Engine ID:", car.getEngineID(), maxWidth);
            printHorizontalLine(maxWidth);

            // In thông tin của khách hàng
            printTableRow("Customer Name:", inforCustomer.getName(), maxWidth);
            printTableRow("Customer Address:", inforCustomer.getAddress(), maxWidth);
            printTableRow("Customer Phone:", inforCustomer.getPhoneNumber(), maxWidth);
            printTableRow("Customer Email:", inforCustomer.getEmail(), maxWidth);
            printHorizontalLine(maxWidth);

            System.out.println("There is/are " + listcus.size() + " bill(s).");
        }
    }

// Phương thức in dòng ngang
    private void printHorizontalLine(int width) {
        for (int i = 0; i < width + 21; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

// Phương thức in dòng trong bảng
    private void printTableRow(String label, String value, int width) {
        System.out.printf("|  %-17s%-" + width + "s|\n", label, value);
    }

    public  void checkAvailableByCarID() {
        boolean x = true;
        String carID = "";
        Set<Car> carSet = listcus.keySet();
        List<Car> carList = new ArrayList<>();
        carList = readCarList("D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\cars.txt");

        do {
            System.out.print("Input carID: ");
            carID = sc.nextLine();
            for (Car car : carList) {
                if (carID.equals(car.getCarID())) {
                    x = false;
                }

            }
        } while (x);
        boolean check = false;

        for (Car car : carSet) {
            if (car.getCarID().equals(carID)) check = true;
               
        }
        
        if(check) System.out.println(carID + " is not available in garage.");
        else System.out.println(carID + " is still available in garage.");
        
    }
}
