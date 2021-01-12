package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import takar.model.Car;

public interface CarRepository  extends CrudRepository<Car, Long> {
}
