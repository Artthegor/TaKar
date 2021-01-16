package takar.dataManagementServices;

import takar.model.Trailer;
import takar.model.Vehicle;


public interface ITrailerManagement {
    public Trailer addTrailer(String brand, String model, Integer placeNumber, Double price, String infoForClient, String description, Double capacity, Double weight, Double length, String licensePlate);
    public Iterable<Trailer> getAllTrailer();
}
