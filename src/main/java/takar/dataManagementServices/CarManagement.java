package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Car;
import takar.repositories.CarRepository;

@Service
public class CarManagement implements ICarManagement {

    @Autowired
    CarRepository carRepo;

    public CarManagement() {
    }

    public Car addVehicle(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note, String year, String motorization, String power, String licensePlate, double trunkVolume) {
        Car c = addVehicle(brand,  model,  placeNumber,  price,  infoForClient,  description,  note,  year,  motorization,  power,  licensePlate,  trunkVolume);
        return carRepo.save(c);
    }

    public Iterable<Car> getAllVehicle()
    {
        return carRepo.findAll();
    }
}
