package Main;

import CarManagement.BrandList;
import CarManagement.Car;
import CarManagement.CarList;
import CarManagement.CustomerList;
import CarManagement.InforCustomer;
import java.util.*;
import java.lang.*;
import Menu.Menu;
import Function.Functions;

public class Main {

    public static void main(String[] args) {
        int choice;
        boolean x = true;
        String brandID, brandCarID;
        Menu menu = new Menu("CAR MANAGER APPLICATION");
        String fileCarsName = "D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\cars.txt";
        String fileBrandsName = "D:\\AssigtmentPRO192\\Assignment\\src\\CarManagement\\brands.txt";
        BrandList brandList = new BrandList();
        CarList carList = new CarList(brandList);
        brandList.loadFromFile(fileBrandsName);
        carList.loadFromFile(fileCarsName);
        CustomerList cl = new CustomerList();
        menu.addNewOption("1 - List all brands");
        menu.addNewOption("2 - Generate random brands");
        menu.addNewOption("3 - Add a new brand");
        menu.addNewOption("4 - Search a brand based on its ID");
        menu.addNewOption("5 - Update a brand");
        menu.addNewOption("6 - Save brands to the file, named brands.txt");
        menu.addNewOption("7 - List all cars in ascending order of brand names");
        menu.addNewOption("8 - List cars based on a part of an input brand name");
        menu.addNewOption("9 - Generate random cars");
        menu.addNewOption("10 - Add a car");
        menu.addNewOption("11 - Remove a car based on its ID");
        menu.addNewOption("12 - Update a car based on its ID");
        menu.addNewOption("13 - Save cars to file, named cars.txt");
        menu.addNewOption("14 - Remove all car on the list");
        menu.addNewOption("15 - Create a bill");
        menu.addNewOption("16 - Print all the bills");
        menu.addNewOption("17 - Find customer by CarID");
        menu.addNewOption("18 - Exit the process");

        do {
            menu.printMenu();
            choice = menu.int_getChoice();
            switch (choice) {
                case 1:
                    brandList.listAllBrands();
                    break;
                case 2:
                    brandList.genRandomBrand();
                    break;
                case 3:
                    brandList.addBrand();
                    break;
                case 4:
                    brandID = Functions.setID("Input brand ID: ", "The brandID must not be blank. Try again !");
                    if (brandList.searchBrandBaseOnID(brandID) == -1) {
                        System.out.print("Brand ID is not found !");
                    } else {
                        System.out.println(brandList.get(brandList.searchBrandBaseOnID(brandID)).toString());
                    }
                    break;
                case 5:
                    brandList.updateBrand();
                    break;
                case 6:
                    brandList.saveToFile(fileBrandsName);
                    break;
                case 7:
                    carList.listCars();
                    break;
                case 8:
                    carList.printBasedBrandName();
                    break;
                case 9:
                    carList.genRandomCar();
                    break;
                case 10:
                    carList.addCar();
                    break;
                case 11:
                    boolean check = carList.removeCar();
                    if (!check) {
                        System.out.println("Car has been not found");
                    }
                    break;
                case 12:
                    check = carList.updateCar();
                    if (!check) {
                        System.out.println("Car has been not found");
                    }
                    break;
                case 13:
                    carList.saveToFile(fileCarsName);
                    break;
                case 14:
                    carList.removeCarList();
                    break;
                case 15:
                    System.out.println("------ Enter your Bill------");
                    cl.makeAnBill();
                    System.out.println();
                    break;
                case 16:
                    cl.printListCustomer();
                    break;
                case 17:
                    System.out.println("Input CarID that you want to check information of customer");
                    cl.checkAvailableByCarID();
                    break;
                case 18:
                    x = false;
                    break;
            }
        } while (x);
    }
}
