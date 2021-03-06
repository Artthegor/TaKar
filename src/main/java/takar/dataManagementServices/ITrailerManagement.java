package takar.dataManagementServices;

import takar.model.Trailer;
import takar.model.User;
import takar.model.Vehicle;


public interface ITrailerManagement {
    public Trailer addTrailer(String brand, String model, Double price, String infoForClient, String description, Double capacity, Double weight, Double length, String licensePlate, User user);
    public Iterable<Trailer> getAllTrailer();
    public Iterable<Long> getAllIds();

    Trailer getByid(Long id);

}
