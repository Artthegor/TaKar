package takar.model;

import javax.persistence.Entity;

@Entity
public class Trailer extends Vehicle {
    double capacity, weight, length;
    String licensePlate;

    public Trailer(){}

    public Trailer(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note, double capacity, double weight, double length, String licensePlate){
        super(brand, model, placeNumber, price, infoForClient, description, note);
        this.capacity = capacity;
        this.length = length;
        this.weight = weight;
        this.licensePlate = licensePlate;
    }

    public Trailer(String brand, String model, int placeNumber, double price, String infoForClient, double capacity, double weight, double length, String licensePlate){
        this(brand, model, placeNumber, price, infoForClient, "", -1,capacity, length, weight, licensePlate);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}