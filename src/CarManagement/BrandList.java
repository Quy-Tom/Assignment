
package CarManagement;


import java.io.*;
import java.util.*;
import java.lang.*;

public class BrandList extends ArrayList<Brand> {

    private String brandID, brandName, soundBrand;
    private double price;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> brandIDList = new ArrayList<>();

    public BrandList() {
    }
    
    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                brandIDList.add(brandID);
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand brand : this) {
                String line = brand.getBrandID() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand() + ": " + brand.getPrice();
                pw.println(line);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
