package takar.dataManagementServices;

import takar.model.Bicycle;
import takar.model.User;


public interface IBicycleManagement {
    public Bicycle addBicycle(String brand, String model, double price, String infoForClient, String description, String type, String size, Boolean isElectrical, User user);
    public Iterable<Bicycle> getAllBicycle();
    public Iterable<Long> getAllIds();
}
