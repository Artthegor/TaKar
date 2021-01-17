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

    public Bicycle addBicycle(String brand, String model, double price, String infoForClient, String description, String type, String size, Boolean isElectrical, User user) {
        Vehicle vehicle = new Vehicle(brand, model, price, infoForClient, description, -1, user);

        vehicle = vehicleRepo.save(vehicle);
        Bicycle bicycle = new Bicycle(type, size, isElectrical, vehicle);

        return bicRepo.save(bicycle);
    }

    public Iterable<Bicycle> getAllBicycle()
    {
        return bicRepo.findAll();
    }
    public Iterable<Long> getAllIds(){
        return bicRepo.getAllId();
    }
    public Bicycle getByid(Long id){
        return bicRepo.getByid(id);
    }
}