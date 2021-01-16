package takar.dataManagementServices;

import takar.model.Bicycle;


public interface IBicycleManagement {
    public Bicycle addBicycle(String brand, String model, double price, String infoForClient, String description, String type, String size, Boolean isElectrical);
    public Iterable<Bicycle> getAllBicycle();
}
