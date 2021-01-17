package takar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import takar.model.Bicycle;

public interface BicycleRepository  extends CrudRepository<Bicycle, Long> {
    @Query(value ="select vehicle.id from #{#entityName} ")
    public Iterable<Long> getAllId();

    @Query(value ="from Bicycle where vehicle.id = :id")
    public Bicycle getByid(@Param("id") Long id);

}
