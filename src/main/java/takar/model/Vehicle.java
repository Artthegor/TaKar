package takar.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long vehicleID;

    String brand;
    String model;
    int placeNumber;
    String description;
    double price;
    String infoForClient;
    int note;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int placeNumber, String description, double price, String infoForClient, int note) {
        this.brand = brand;
        this.model = model;
        this.placeNumber = placeNumber;
        this.description = description;
        this.price = price;
        this.infoForClient = infoForClient;
        this.note = note;
    }

    public long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfoForClient() {
        return infoForClient;
    }

    public void setInfoForClient(String infoForClient) {
        this.infoForClient = infoForClient;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
