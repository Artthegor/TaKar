package takar.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import takar.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>  {
}
