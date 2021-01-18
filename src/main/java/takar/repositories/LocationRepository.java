package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import takar.model.Location;
import takar.model.User;
import takar.model.Vehicle;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    public Iterable<Location>findAllByUser(User user);
    public Iterable<Location>findAllByVehicleIdVehicle(Long idVehicle);
}
