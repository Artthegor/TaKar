package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import takar.model.Vehicle;

public interface VehicleRepository  extends CrudRepository<Vehicle, Long> {
}
