package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Location;
import takar.model.User;
import takar.model.Vehicle;
import takar.repositories.LocationRepository;

import java.util.Date;

@Service
public class LocationManagement implements ILocationManagement{

    @Autowired
    LocationRepository locaRepo;

    public Location addLocation(Vehicle vehicle, Date start, Date end, User user){
        Location location = new Location(start, end, 42, vehicle, user);
        return locaRepo.save(location);
    }
}
