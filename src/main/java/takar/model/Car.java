package takar.model;

import javax.persistence.*;

@Entity
public class Car extends Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long IdVehicle;


    String year, motorization, power, licensePlate;
    int placeNumber;
    Double trunkVolume;

    @OneToOne
    Vehicle vehicle;

    public Car(){}

    public Car(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, Integer note, String year, String motorization, String power, String licensePlate, Double trunkVolume,Vehicle vehicle){
        super(brand, model, price, infoForClient, description, note);
        this.placeNumber =placeNumber;
        this.licensePlate = licensePlate;
        this.motorization = motorization;
        this.power = power;
        this.trunkVolume = trunkVolume;
        this.year = year;
        this.vehicle = vehicle;
    }

    public Car(String brand, String model, Integer placeNumber, Double price, String infoForClient, String year, String motorization, String power, String licensePlate, Double trunkVolume, Vehicle vehicle){
        this(brand, model, placeNumber, price, infoForClient, "", -1, year, motorization,power, licensePlate, trunkVolume, vehicle);
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
