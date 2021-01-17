package takar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import takar.model.Trailer;

public interface TrailerRepository  extends CrudRepository<Trailer, Long> {
    @Query(value ="select vehicle.id from #{#entityName} ")
    public Iterable<Long> getAllId();

    @Query(value ="from Car where vehicle.id = :id")
    public Trailer getByid(Long id);

}
