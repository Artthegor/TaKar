package takar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long IdCar;


    String year, motorization, power, licensePlate;
    int placeNumber;
    Double trunkVolume;

    @OneToOne
    Vehicle vehicle;

    public Car(){}

    public Car(Integer placeNumber, String year, String motorization, String power, String licensePlate, Double trunkVolume,Vehicle vehicle){
        this.placeNumber =placeNumber;
        this.licensePlate = licensePlate;
        this.motorization = motorization;
        this.power = power;
        this.trunkVolume = trunkVolume;
        this.year = year;
        this.vehicle = vehicle;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }


    public double getTrunkVolume() {
        return trunkVolume;
    }

    public String getMotorization() {
        return motorization;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getPower() {
        return power;
    }

    public String getYear() {
        return year;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMotorization(String motorization) {
        this.motorization = motorization;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setTrunkVolume(double trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
