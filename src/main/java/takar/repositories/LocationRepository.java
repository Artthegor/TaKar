package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import takar.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
