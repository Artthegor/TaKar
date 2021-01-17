package takar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import takar.model.User;
import takar.model.Vehicle;

public interface VehicleRepository  extends CrudRepository<Vehicle, Long> {
    public Iterable<Vehicle> findAllByIdVehicleIn(Iterable<Long> ids);

    public Iterable<Vehicle> findAllByIdVehicleInAndPriceLessThanEqualAndNoteGreaterThanEqual(Iterable<Long> ids, Double price, int note);
    @Query(value ="select idVehicle from #{#entityName} ")
    public Iterable<Long> findAllId();
    public Iterable<Vehicle>findAllByUser(User user);
}