package takar.dataManagementServices;

import takar.model.Car;


public interface ICarManagement {
    public Car addVehicle(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note, String year, String motorization, String power, String licensePlate, double trunkVolume);
    public Iterable<Car> getAllVehicle();
}
