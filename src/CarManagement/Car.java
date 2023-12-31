package CarManagement;

import java.util.*;
import java.lang.*;

public class Car implements Comparable<Car> {

    private String carID, color, frameID, engineID;
    public Brand brand;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    

    @Override
    public int compareTo(Car car) {
        int d = this.getBrand().getBrandName().compareTo(car.getBrand().getBrandName());
        if (d!=0) return d;
        return this.getCarID().compareTo(car.getCarID()); 
    }

    @Override
    public String toString() {
        return "<" + carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID + ">";
    }
    
     public String screenString () {
        return brand + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
     
    @Override
     public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + ((carID == null) ? 0 : carID.hashCode());
         return result;
     }
     
     public boolean equals(Object obj) {
         if(this == obj) return true;
         if(obj == null || this.getClass() != obj.getClass()) return false;
         Car other = (Car) obj;
         return carID.equals(other.carID);
     }
         
     
}

