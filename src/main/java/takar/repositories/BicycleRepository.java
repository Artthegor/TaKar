package takar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import takar.model.Bicycle;

public interface BicycleRepository  extends CrudRepository<Bicycle, Long> {
    @Query(value ="select vehicle.id from #{#entityName} ")
    public Iterable<Long> getAllId();

    @Query(value ="from Car where vehicle.id = :id")
    public Bicycle getByid(Long id);

}
