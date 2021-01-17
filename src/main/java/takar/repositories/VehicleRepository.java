package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import takar.model.User;
import takar.model.Vehicle;

public interface VehicleRepository  extends CrudRepository<Vehicle, Long> {
    public Iterable<Vehicle> findAllByIdVehicleIn(Iterable<Long> ids);
}
