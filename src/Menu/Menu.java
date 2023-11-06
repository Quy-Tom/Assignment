package Menu;

import CarManagement.Brand;
import CarManagement.BrandList;
import java.util.*;
import java.lang.*;
import Function.Functions;

public class Menu {

    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public Menu() {
        
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println(menuTitle);
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    public int int_getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Please choose an option [1 - " + maxOption + "]: ";
        String errorMsg = "You must choose an option 1 - " + maxOption;
        return Functions.setAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
    public Brand ref_getChoice(ArrayList<Brand> options) {
        int maxOption = options.size();
        int response;
        System.out.println("Brand ID list:");
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > maxOption);
        return options.get(response - 1);
    }

    private int int_getChoice(ArrayList<Brand> options) {
        int maxOption = options.size();
        int response;
        for (int i = 0; i < maxOption; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        String inputMsg = "Please choose an option [1 - " + maxOption + "]: ";
        String errorMsg = "You must choose an option 1 - " + maxOption;
        response = Functions.setAnInteger(inputMsg, errorMsg, 1, maxOption);
        return response;
    }
}
