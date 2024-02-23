/*
Title: Car Class Definition
Author: Draedn Groves
Date: Feb.15/2024
Purpose: Car Class Definition
 */


import java.util.ArrayList;

// Car class
public class Car {

    private static int autoVin = 1;


    // <editor-fold desc="Properties">
    private int vin;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String color;
    private String owner;
    // </editor-fold>
    // <editor-fold desc="Constructors">


    // default constructor (customizer)
    public Car(){

    }

    // parameterized constructor (overload)
    public Car(int vin, int year, String make, String model,
    String trim, String color, String owner){

        setVin(vin);
        setYear(year);
        setMake(make);
        setModel(model);
        setTrim(trim);
        setColor(color);
        setOwner(owner);

        // this.vin = vin; // this. = referring to itself
        // this.year = year;
        // etc // Don't use this though
    }

    // </editor-fold>

    // <editor-fold desc="Getters and Setters">
    public int getVin() {return vin;}
    public int getYear() {return year;}
    public String getMake() {return make;}
    public String getModel() {return model;}
    public String getTrim() {return trim;}
    public String getColor() {return color;}
    public String getOwner() {return owner;}

    public void setVin (int vin){

        if (vin == 0) {
            vin = autoVin++;

        }
        this.vin = vin;
    }

    public void setYear (int year){ this.year = year;}
    public void setMake (String make){ this.make = make;}
    public void setModel (String model){ this.model = model;}
    public void setTrim (String trim){ this.trim = trim;}
    public void setColor (String color){ this.color = color;}
    public void setOwner (String owner){ this.owner = owner;}
    // </editor-fold>

    // <editor-fold desc="Instance Methods">
    public void printCar() {
        System.out.println(String.format("""
                ------------------------------
                vin: %d - %d %s %s %s %s
                    owner: %s
                ------------------------------
                """, getVin(), getYear(), getMake(), getModel(), getTrim(), getColor(), getOwner()));
    }
    // </editor-fold>

    // <editor-fold desc="Static Methods">
    public static Car findCarByVin(int vin, ArrayList<Car> cars){
        Car returnCar = new Car();
        for (Car car: cars) {
            if (car.getVin()== vin) {
                returnCar = car;
            }
        }
        return returnCar;
    }
    // </editor-fold>

}
