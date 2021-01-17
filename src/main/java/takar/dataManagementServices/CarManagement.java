package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Car;
import takar.model.Client;
import takar.model.User;
import takar.model.Vehicle;
import takar.repositories.CarRepository;
import takar.repositories.VehicleRepository;

@Service
public class CarManagement implements ICarManagement {

    @Autowired
    CarRepository carRepo;
    @Autowired
    VehicleRepository vehicleRepo;

    public CarManagement() {
    }

    public Car addCar(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, String year, String motorization, String power, String licensePlate, Double trunkVolume, User user) {
        Vehicle vehicle = new Vehicle(brand, model, price, infoForClient, description, -1, user);

        vehicle = vehicleRepo.save(vehicle);
        Car car = new Car(placeNumber, year,motorization,power,licensePlate,trunkVolume, vehicle);

        return carRepo.save(car);
    }

    public Iterable<Car> getAllCar()
    {
        return carRepo.findAll();
    }
}
