package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import takar.model.Bicycle;

public interface BicycleRepository  extends CrudRepository<Bicycle, Long> {
}
