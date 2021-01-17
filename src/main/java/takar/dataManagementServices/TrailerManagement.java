package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.*;
import takar.repositories.TrailerRepository;
import takar.repositories.VehicleRepository;

@Service
public class TrailerManagement implements ITrailerManagement {

    @Autowired
    TrailerRepository traiRepo;
    @Autowired
    VehicleRepository vehicleRepo;

    public TrailerManagement() {
    }

    public Trailer addTrailer(String brand, String model, Double price, String infoForClient, String description, Double capacity, Double weight, Double length, String licensePlate, User user) {
        Vehicle vehicle = new Vehicle(brand, model, price, infoForClient, description, 0, user);

        vehicle = vehicleRepo.save(vehicle);
        Trailer trailer = new Trailer(capacity, weight, length, licensePlate, vehicle);

        return traiRepo.save(trailer);
    }

    public Iterable<Trailer> getAllTrailer()
    {
        return traiRepo.findAll();
    }
    public Iterable<Long> getAllIds(){
        return traiRepo.getAllId();
    }
    public Trailer getByid(Long id){
        return traiRepo.getByid(id);
    }
}