package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Vehicle;
import takar.repositories.VehicleRepository;

@Service
public class VehicleManagement implements IVehicleManagement{

    @Autowired
    VehicleRepository vehicleRepo;

    public VehicleManagement() {}

    public Vehicle addVehicle(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note) {
        Vehicle v = addVehicle(brand, model, placeNumber, description, price, infoForClient, note);
        return vehicleRepo.save(v);
    }

    public Iterable<Vehicle> getAllVehicle()
    {
        return vehicleRepo.findAll();
    }


}
