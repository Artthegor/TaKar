package takar.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import takar.model.Car;

public interface CarRepository  extends CrudRepository<Car, Long> {
    @Query(value ="select vehicle.id from #{#entityName} ")
    public Iterable<Long> getAllId();

    @Query(value ="from Car where vehicle.id = :id")
    public Car getByid(Long id);

}
