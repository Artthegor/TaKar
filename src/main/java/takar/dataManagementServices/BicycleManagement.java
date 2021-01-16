package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.*;
import takar.repositories.BicycleRepository;
import takar.repositories.VehicleRepository;

@Service
public class BicycleManagement implements IBicycleManagement {

    @Autowired
    BicycleRepository bicRepo;
    @Autowired
    VehicleRepository vehicleRepo;

    public BicycleManagement() {
    }

    public Bicycle addBicycle(String brand, String model, int placeNumber, double price, String infoForClient, String description, String type, String size, Boolean isElectrical) {
        Vehicle vehicle = new Vehicle(brand, model, placeNumber, price, infoForClient, description, -1);

        vehicle = vehicleRepo.save(vehicle);
        Bicycle bicycle = new Bicycle(brand, model, placeNumber, price, infoForClient, description, -1, type, size, isElectrical, vehicle);

        return bicRepo.save(bicycle);
    }

    public Iterable<Bicycle> getAllBicycle()
    {
        return bicRepo.findAll();
    }
}