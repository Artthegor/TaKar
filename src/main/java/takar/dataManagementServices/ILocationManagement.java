package takar.dataManagementServices;

import takar.model.Location;
import takar.model.User;
import takar.model.Vehicle;

import java.util.Date;

public interface ILocationManagement {
    public Location addLocation(Vehicle vehicle, Date start, Date end, User user);
}
