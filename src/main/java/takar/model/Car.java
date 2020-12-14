package takar.model;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
    String year, motorization, power, licensePlate;
    double trunkVolume;

    public Car(){}

    public Car(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note, String year, String motorization, String power, String licensePlate, double trunkVolume){
        super(brand, model, placeNumber, price, infoForClient, description, note);
        this.licensePlate = licensePlate;
        this.motorization = motorization;
        this.power = power;
        this.trunkVolume = trunkVolume;
        this.year = year;
    }

    public Car(String brand, String model, int placeNumber, double price, String infoForClient, String year, String motorization, String power, String licensePlate, double trunkVolume){
        this(brand, model, placeNumber, price, infoForClient, "", -1, year, motorization,power, licensePlate, trunkVolume);
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
}
