package takar.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Trailer extends Vehicle {
    double capacity, weight, length;
    String licensePlate;

    @OneToOne
    Vehicle vehicle;

    public Trailer(){}

    public Trailer(String brand, String model, double price, String infoForClient, String description, int note, double capacity, double weight, double length, String licensePlate, Vehicle vehicle){
        super(brand, model, price, infoForClient, description, note);
        this.capacity = capacity;
        this.length = length;
        this.weight = weight;
        this.licensePlate = licensePlate;
        this.vehicle = vehicle;
    }

    public Trailer(String brand, String model, double price, String infoForClient, double capacity, double weight, double length, String licensePlate, Vehicle vehicle){
        this(brand, model, price, infoForClient, "", -1,capacity, length, weight, licensePlate, vehicle);
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
