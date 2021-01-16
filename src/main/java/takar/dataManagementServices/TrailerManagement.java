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

    public Trailer addTrailer(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, Double capacity, Double weight, Double length, String licensePlate) {
        Vehicle vehicle = new Vehicle(brand, model, placeNumber, price, infoForClient, description, -1);

        vehicle = vehicleRepo.save(vehicle);
        //    public Client(String username, String password, String name, String firstname, String sex, String description, String mail, String phoneNumber) {
        Trailer trailer = new Trailer( brand,  model,  placeNumber,  price,  infoForClient, description, -1, capacity, weight, length, licensePlate, vehicle);
        /*Client cli = registerUser(name, lastname,  password, sexe,
                mail, telephone, adresse, ville, departement, cp, pays);*/

        return traiRepo.save(trailer);
    }

    public Iterable<Trailer> getAllTrailer()
    {
        return traiRepo.findAll();
    }
}