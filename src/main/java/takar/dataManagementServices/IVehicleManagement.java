package takar.dataManagementServices;

import takar.model.Vehicle;

import java.util.Iterator;

public interface IVehicleManagement {
    public Vehicle addVehicle(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note);
    public Iterable<Vehicle> getAllVehicle();
    public Iterable<Vehicle> getVehicleByIds(Iterable<Long> ids);
}
