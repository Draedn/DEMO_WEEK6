/*
Title: Service
Author: Draedn Groves
Date: Feb.22/2024
Purpose: Service class?
 */

import java.util.ArrayList;

public class Service {

    // <editor-fold desc="Properties">
    private String serviceCode; // a unique service code representing the overall service (parts and labour)
    private String serviceName; // A short descriptive name for reference
    private String description; // 	A longer description for details beyond what would be included in a simple list.
    private double basePrice; // the cost of a single unit
    private double timeRequired; // the value represent the number of hours the service will take,
     //----------------------->>>// rounded to the closed 1/4 hour (15 minutes)
    private boolean isActive; // a boolean indicator if the service is currently available

    private static int autoServiceCode = 1; // Ensures a unique CODE
    // </editor-fold>


    // default constructor (customizer)
    public Service(){

    }
    // <editor-fold desc="Overload">
    public Service(String serviceCode, String serviceName, String description,
                   double basePrice, double timeRequired, boolean isActive){

        setServiceCode(serviceCode);
        setServiceName(serviceName);
        setDescription(description);
        setBasePrice(basePrice);
        setTimeRequired(timeRequired);
        setIsActive(isActive);

    }

    public Service(String serviceCode, String serviceName){

        setServiceCode(serviceCode);
        setServiceName(serviceName);
    }
    // </editor-fold>


    // <editor-fold desc="Getters">
    public String getServiceCode() {
        if (serviceCode != null && serviceCode.length() == 4 && serviceCode.matches("[a-zA-Z0-9]*")) {
            return serviceCode;
        } else {
            return "It must be exactly 4 chars and alphanumeric!";
        }
    }
    public String getServiceName() {
        if (serviceName != null && serviceName.length() < 50 && serviceCode.matches("[a-zA-Z0-9]*")) {
            return serviceName;
        }
        else {
            return "It must be less than 50 chars and alphanumeric!";
        }
    }
    public String getDescription() {
        if (description != null && description.length() < 200 && description.matches("[a-zA-Z0-9]*")) {
            return description;
        }
        else {
            return "It must be less than 225 chars and alphanumeric!";
        }
    }
    public double getBasePrice() {
        return basePrice;
    }
    public double getTimeRequired() {
        return timeRequired;
    }
    public boolean getIsActive() {
        return isActive;
    }
    // </editor-fold>


    // <editor-fold desc="Setters">
    public void setServiceCode(String serviceCode) {
        if (serviceCode != null && serviceCode.length() == 4 && serviceCode.matches("[a-zA-Z0-9]*")) {
            this.serviceCode = serviceCode;
        } else if (serviceCode == null || serviceCode.isEmpty()) {
            this.serviceCode = String.format("%04d", autoServiceCode++);
        } else {
            System.out.println("Invalid input. It must be exactly 4 chars and alphanumeric!");
        }
    }

    public void setServiceName(String serviceName) {
        if (serviceName != null && serviceName.length() < 50 && serviceName.matches("[a-zA-Z0-9]*")) {
            this.serviceName = serviceName;
        } else {
            System.out.println("Invalid input. It must be less than 50 chars and alphanumeric!");
        }
    }

    public void setDescription(String description) {
        if (description != null && description.length() < 200 && description.matches("[a-zA-Z0-9]*")) {
            this.description = description;
        } else {
            System.out.println("Invalid input. It must be less than 225 chars and alphanumeric!");
        }
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0.00 && basePrice <= 5000.00) {
            this.basePrice = Math.round(basePrice * 100.0) / 100.0;
        } else {
            throw new IllegalArgumentException("Invalid base price. " +
                    "It must be a double with 2 decimal places, between 0.00 and 5,000.00");
        }
    }

    public void setTimeRequired(double timeRequired) {
        if (timeRequired >= 0.00 && timeRequired <= 100.00) {
            this.timeRequired = Math.round(timeRequired * 100.0) / 100.0;
        } else {
            throw new IllegalArgumentException("Invalid time required. " +
                    "It must be a double with 2 decimal places, between 0.00 and 100.00");
        }
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // <editor-fold desc="Instance Methods">

    // Changes the active status of the object. If it was true, it will become false, and if it was false, it will become true.
    public void flipActive() {
        this.isActive = !this.isActive;
    }

    // Sets the properties of the current object to default values.
    private void setDefaults() {
        this.serviceName = "unknown";
        this.description = "";
        this.basePrice = 0.00;
        this.timeRequired = 0.00;
        this.isActive = false;
    }

    // Returns a string that represents the output of printing out the details of the current instantiated object.
    public String toString() {
        return "Service Code: " + getServiceCode() +
                ", Service Name: " + getServiceName() +
                ", Description: " + getDescription() +
                ", Base Price: " + getBasePrice() +
                ", Time Required: " + getTimeRequired() +
                ", Is Active: " + getIsActive();
    }
    // </editor-fold>
    // </editor-fold>

    // <editor-fold desc="Static Methods">

    // Returns a string that represents a table of services.
    public static String toTable(ArrayList<Service> services) {
        StringBuilder table = new StringBuilder();
        for (Service service : services) {
            table.append(service.toString()).append("\n");
        }
        return table.toString();
    }

    // Receives an ArrayList of Services, searches through the list based on the service code, and returns the base price.
    public static double getPrice(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service.getBasePrice();
            }
        }
        throw new IllegalArgumentException("Service with code " + serviceCode + " not found.");
    }

    // Takes a given service code and returns a Service object.
    public static Service findService(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }
        throw new IllegalArgumentException("Service with code " + serviceCode + " not found.");
    }
    // </editor-fold>
}