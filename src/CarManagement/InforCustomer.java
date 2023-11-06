package CarManagement;

import CarManagement.CarList;
import java.util.*;
import java.lang.*;

public class InforCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Car car;

    public InforCustomer() {
    }

    public InforCustomer(String name, String address, String phoneNumber, String email, Car car) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
