package takar.dataManagementServices;

import takar.model.Location;
import takar.model.User;
import takar.model.Vehicle;

import java.util.Date;

public interface ILocationManagement {
    public Location addLocation(Vehicle vehicle, Date start, Date end, User user);

    public Iterable<Location> getMyRent(User user);
    public void suppr(Long location);
    public Iterable<Location> getRentByVehicle(Long idVehicle);
}
