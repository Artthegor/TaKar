package takar.dataManagementServices;

import takar.model.Car;
import takar.model.User;


public interface ICarManagement {
    public Car addCar(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, String year, String motorization, String power, String licensePlate, Double trunkVolume, User user);
    public Iterable<Car> getAllCar();
    public Iterable<Long> getAllIds();
}
