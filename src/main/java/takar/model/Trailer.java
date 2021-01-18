package takar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trailer implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long IdTrailer;
    double capacity, weight, length;
    String licensePlate;

    @OneToOne
    Vehicle vehicle;

    public Trailer(){}

    public Trailer( double capacity, double weight, double length, String licensePlate, Vehicle vehicle){
        this.capacity = capacity;
        this.length = length;
        this.weight = weight;
        this.licensePlate = licensePlate;
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return vehicle;
    }
}
