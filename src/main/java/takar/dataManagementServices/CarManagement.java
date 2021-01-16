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

    public Car addCar(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, String year, String motorization, String power, String licensePlate, Double trunkVolume) {
        Vehicle vehicle = new Vehicle(brand, model, price, infoForClient, description, -1);

        vehicle = vehicleRepo.save(vehicle);
        //    public Client(String username, String password, String name, String firstname, String sex, String description, String mail, String phoneNumber) {
        Car car = new Car(brand, model,placeNumber, price, infoForClient,description,0, year,motorization,power,licensePlate,trunkVolume, vehicle);
        /*Client cli = registerUser(name, lastname,  password, sexe,
                mail, telephone, adresse, ville, departement, cp, pays);*/

        return carRepo.save(car);
    }

    public Iterable<Car> getAllCar()
    {
        return carRepo.findAll();
    }
}
