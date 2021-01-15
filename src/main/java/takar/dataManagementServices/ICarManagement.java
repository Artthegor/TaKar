package takar.dataManagementServices;

import takar.model.Car;


public interface ICarManagement {
    public Car addCar(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, String year, String motorization, String power, String licensePlate, Double trunkVolume);
    public Iterable<Car> getAllCar();
}
