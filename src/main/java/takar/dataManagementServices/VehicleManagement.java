package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.User;
import takar.model.Vehicle;
import takar.repositories.VehicleRepository;

import java.util.Iterator;

@Service
public class VehicleManagement implements IVehicleManagement{

    @Autowired
    VehicleRepository vehicleRepo;

    public VehicleManagement() {}

    public Vehicle addVehicle(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note) {
        Vehicle v = addVehicle(brand, model, placeNumber, description, price, infoForClient, note);
        return v;
    }

    public Iterable<Vehicle> getAllVehicle()
    {
        return vehicleRepo.findAll();
    }

    public Iterable<Vehicle> getVehicleByIds(Iterable<Long> ids){
        return vehicleRepo.findAllByIdVehicleIn(ids);
    }

    public Iterable<Vehicle> getVehicleFilter(Iterable<Long> ids,Double price,int note){
        return vehicleRepo.findAllByIdVehicleInAndPriceLessThanEqualAndNoteGreaterThanEqual(ids,price,note);
    }


    public Iterable<Long> getAllIds(){
        return vehicleRepo.findAllId();
    }

    public Iterable<Vehicle> getMyLocation(User user){
        return vehicleRepo.findAllByUser(user);
    }


    public Vehicle getVehicleById(Long id) {
        return vehicleRepo.findByIdVehicle(id);
    }

    public void suppr(Long idVehicle){
        vehicleRepo.delete(idVehicle);
    }
}
